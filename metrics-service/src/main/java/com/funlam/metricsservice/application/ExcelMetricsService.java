package com.funlam.metricsservice.application;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class ExcelMetricsService {

    @Value("${metrics.excel.output-directory:./metrics-data}")
    private String outputDirectory;

    private static final String FILE_PREFIX = "user-registrations-";
    private static final String FILE_EXTENSION = ".xlsx";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void recordUserRegistration(String id, String nombre, String apellido, String email,
                                       Integer edad, String telefono, String direccion, Long timestamp) {
        try {
            ensureOutputDirectoryExists();
            String fileName = getFileNameForDate(LocalDate.now());
            File file = new File(outputDirectory, fileName);

            Workbook workbook;
            Sheet sheet;

            if (file.exists() && file.length() > 0) {
                // Abrir archivo existente
                log.debug("Abriendo archivo existente: {}", file.getAbsolutePath());
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fis);
                    sheet = workbook.getSheetAt(0);
                }
            } else {
                // Crear nuevo archivo
                if (file.exists() && file.length() == 0) {
                    log.warn("El archivo {} existe pero está vacío. Se recreará.", file.getAbsolutePath());
                } else {
                    log.info("Creando nuevo archivo Excel: {}", file.getAbsolutePath());
                }
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Registros de Usuarios");
                createHeader(sheet, workbook);
            }

            // Agregar nueva fila con los datos
            int lastRowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRowNum + 1);

            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(nombre);
            row.createCell(2).setCellValue(apellido);
            row.createCell(3).setCellValue(email);
            row.createCell(4).setCellValue(edad);
            row.createCell(5).setCellValue(telefono != null ? telefono : "N/A");
            row.createCell(6).setCellValue(direccion != null ? direccion : "N/A");
            row.createCell(7).setCellValue(formatTimestamp(timestamp));

            // Guardar el archivo
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
            workbook.close();

            log.info("Registro guardado exitosamente en {}", file.getAbsolutePath());

        } catch (IOException e) {
            log.error("Error al escribir en el archivo Excel", e);
            throw new RuntimeException("Error al escribir en el archivo Excel", e);
        }
    }

    private void createHeader(Sheet sheet, Workbook workbook) {
        Row headerRow = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        String[] headers = {"ID", "Nombre", "Apellido", "Email", "Edad", "Teléfono", "Dirección", "Fecha de Registro"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
            sheet.autoSizeColumn(i);
        }
    }

    private void ensureOutputDirectoryExists() {
        File dir = new File(outputDirectory);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (created) {
                log.info("Directorio de salida creado: {}", dir.getAbsolutePath());
            } else {
                log.warn("No se pudo crear el directorio de salida: {}", dir.getAbsolutePath());
            }
        }
    }

    private String getFileNameForDate(LocalDate date) {
        return FILE_PREFIX + date.format(DATE_FORMATTER) + FILE_EXTENSION;
    }

    private String formatTimestamp(Long timestamp) {
        if (timestamp == null) {
            return "N/A";
        }
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

