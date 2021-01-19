package com.lss.service;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

/**
 * @author lss
 * @version 1.0
 * @date 2020-12-16 10:45
 * @description
 */
public interface PDFService {
    void mergePdfFiles(List<String> files, String newfile) throws IOException, DocumentException;
    String splitPDF(String source, String newFile, int start, int end);

}
