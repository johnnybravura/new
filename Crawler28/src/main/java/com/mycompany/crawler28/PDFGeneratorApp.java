/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawler28;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PDFGeneratorApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PDFGeneratorGUI();
        });
    }
}

class PDFGeneratorGUI {

    private final JFrame frame;
    private final JTable table;

    public PDFGeneratorGUI() {
        frame = new JFrame("PDF Generator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel z tabelą
        JPanel tablePanel = new JPanel(new BorderLayout());
        table = new JTable();

        // Dodajemy tabelę do JScrollPane, aby obsłużyć ewentualne przewijanie
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Przycisk do generowania PDF
        JButton generatePDFButton = new JButton("Generuj PDF");
        generatePDFButton.addActionListener(e -> {
            // Tutaj wykonujemy generowanie PDF i zapisujemy dane z tabeli
            generatePDF();
        });

        // Dodajemy komponenty do ramki
        frame.add(generatePDFButton, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.CENTER);

        // Ustawienia okna
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void generatePDF() {
        Vector<Vector<String>> data = fetchDataFromWebsite(); // Pobierz dane (tu możesz dostosować do swoich potrzeb)

        // Generuj PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                float margin = 50;
                float yStart = page.getMediaBox().getHeight() - margin;
                float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
                float yPosition = yStart;
                float tableHeight = table.getHeight();
                float marginBotton = 70;
                float cellMargin = 5f;

                // Dane tabeli
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int rows = model.getRowCount();
                int cols = model.getColumnCount();
                float tableTopYPosition = yStart - 20;

                // Rysuj nagłówki
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Nazwa");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText("Cena");
                contentStream.endText();

                yPosition -= 20;

                // Rysuj dane
                for (int i = 0; i < rows; i++) {
                    yPosition -= table.getRowHeight();

                    for (int j = 0; j < cols; j++) {
                        String cellValue = model.getValueAt(i, j).toString();
                        contentStream.beginText();
                        contentStream.newLineAtOffset(margin + j * (tableWidth / cols), yPosition - table.getRowHeight() + 5);
                        contentStream.showText(cellValue);
                        contentStream.endText();
                    }
                }

                // Zapisz do pliku
                String pdfFileName = "output.pdf";
                document.save(pdfFileName);
                JOptionPane.showMessageDialog(frame, "Plik PDF został utworzony: " + pdfFileName);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Vector<Vector<String>> fetchDataFromWebsite() {
        // Tutaj umieść logikę do pobrania danych ze strony
        Vector<Vector<String>> data = new Vector<>();
        // ...

        return data;
    }
}
