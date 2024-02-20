/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawler28;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductComparisonApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductComparisonGUI();
        });
    }
}

class ProductComparisonGUI {

    private final JFrame frame;
    private final JTable table;
    private final JComboBox<String> categoryComboBox;
    private final JTextField searchTextField;

    public ProductComparisonGUI() {
        frame = new JFrame("Product Comparison App");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel z tabelą
        JPanel tablePanel = new JPanel(new BorderLayout());
        table = new JTable();

        // Dodajemy tabelę do JScrollPane, aby obsłużyć ewentualne przewijanie
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Panel z wyborem kategorii i polem wyszukiwania
        JPanel controlPanel = new JPanel();
        categoryComboBox = new JComboBox<>(new String[]{"mleko", "inne_kategorie"}); // Dodaj więcej kategorii według potrzeb
        searchTextField = new JTextField(20);

        JButton compareButton = new JButton("Porównaj Produkty");
        compareButton.addActionListener(e -> {
            // Tutaj wykonujemy porównanie produktów i aktualizujemy dane w tabeli
            String selectedCategory = (String) categoryComboBox.getSelectedItem();
            String searchText = searchTextField.getText();
            Vector<Vector<String>> data = fetchDataFromWebsites(selectedCategory, searchText);
            updateTable(data);
        });

        controlPanel.add(new JLabel("Wybierz kategorię: "));
        controlPanel.add(categoryComboBox);
        controlPanel.add(new JLabel("Wpisz wyszukiwanie: "));
        controlPanel.add(searchTextField);
        controlPanel.add(compareButton);

        // Dodajemy komponenty do ramki
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.CENTER);

        // Ustawienia okna
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Vector<Vector<String>> fetchDataFromWebsites(String category, String searchQuery) {
        // Pobierz dane z dwóch stron internetowych dla wybranej kategorii
        Vector<Vector<String>> data = new Vector<>();

        String url1 = "http://polskikoszyk.pl";
        String url2 = "http://www.carrefour.pl";

        try {
            Elements elements1 = Jsoup.connect(url1).get().select("div.product-card");
            Elements elements2 = Jsoup.connect(url2).get().select("div.product");

            for (Element element : elements1) {
                String productName = element.select("h2.product-card-title a").text();
                String productPrice = element.select("span.price").text();
                Vector<String> row = new Vector<>();
                row.add("PolskiKoszyk: " + productName);
                row.add(productPrice);
                data.add(row);
            }

            for (Element element : elements2) {
                String productName = element.select("h2.product-title").text();
                String productPrice = element.select("span.price").text();
                Vector<String> row = new Vector<>();
                row.add("Carrefour: " + productName);
                row.add(productPrice);
                data.add(row);
            }

            // Dodaj dane z Biedronki
            Document biedronkaDoc = Jsoup.connect("http://home.biedronka.pl/search?lang=pl_PL&q=" + searchQuery).get();
            Elements biedronkaProducts = biedronkaDoc.getElementsByClass("product-tile__content-wrapper");

            for (Element product : biedronkaProducts) {
                Elements names = product.getElementsByClass("product-tile__name product-tile__name--overflow");
                System.out.println("nazwa= " + names.get(0).text());

                Elements prize = product.getElementsByClass("price-tile__sales");
                System.out.println("cena= " + prize.get(0).text());

                Vector<String> row = new Vector<>();
                row.add("Biedronka: " + names.get(0).text());
                row.add(prize.get(0).text());
                data.add(row);
            }

        } catch (IOException ex) {
            Logger.getLogger(ProductComparisonApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    private void updateTable(Vector<Vector<String>> data) {
        // Utwórz model tabeli
        DefaultTableModel model = new DefaultTableModel();
        // Dodaj kolumny do modelu (np. "Produkt", "Cena")
        model.addColumn("Produkt");
        model.addColumn("Cena");

        // Dodaj dane do modelu
        for (Vector<String> rowData : data) {
            model.addRow(rowData);
        }

        // Ustaw model tabeli
        table.setModel(model);
    }
}
/*W kodzie aplikacji ProductComparisonApp, użyłem wzorca projektowego nazwanego Model-View-Controller (MVC). Poniżej krótkie wyjaśnienie, jak wzorzec ten został zastosowany w kodzie:

Model (Model):

W tym przypadku reprezentuje dane do porównania (produkty i ich ceny), które są przechowywane w tabeli (JTable). Klasa DefaultTableModel jest używana do zarządzania modelem danych tabeli.
Widok (View):

Odpowiada za prezentację danych użytkownikowi. W kodzie jest to GUI (interfejs użytkownika), zbudowany przy użyciu Swing (JFrame, JButton, JTable itp.).
Kontroler (Controller):

Obsługuje interakcje użytkownika i koordynuje komunikację między modelem a widokiem. W kodzie jest to klasa ProductComparisonGUI, która reaguje na kliknięcia przycisku "Porównaj Produkty" i odpowiada za aktualizację tabeli w oparciu o dane z modelu.
Wzorzec MVC pomaga oddzielić logikę biznesową od warstwy prezentacji, co ułatwia utrzymanie i rozwijanie aplikacji. Model odpowiada za dane, widok za ich prezentację, a kontroler za interakcję między nimi.

Warto zauważyć, że w rzeczywistych projektach zastosowanie wzorca MVC może być bardziej złożone, a struktura kodu może różnić się w zależności od konkretnych wymagań i implementacji.*/