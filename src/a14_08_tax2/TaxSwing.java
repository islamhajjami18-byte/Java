/*
* TaxSwing.java
*
* This is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation v3.
*
* @see <a href="http://www.gnu.org/licenses/gpl.html">GNU License</a> for more information.
*
* Copyright (c) Joan Seculi <a href="mailto:joan.seculi@gmail.com">Joan Seculi</a>
*/
package a14_08_tax2;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

/**
 * TaxSwing.java - Modern Swing test harness for the Tax class.
 *
 * <p>This window does not contain a student section. It calls the three
 * static methods of {@link Tax} with the same price so the student can see
 * all the calculations at once:</p>
 *
 * <ul>
 *   <li>{@link Tax#tax(float)} - VAT for a price without tax</li>
 *   <li>{@link Tax#priceWithTax(float)} - price plus VAT</li>
 *   <li>{@link Tax#getTaxFromPrice(float)} - VAT included in a total</li>
 * </ul>
 */
public class TaxSwing extends JFrame {

    private static final Color PRIMARY = new Color(13, 148, 136);
    private static final Color PRIMARY_DARK = new Color(15, 118, 110);
    private static final Color HEADER_START = new Color(15, 23, 42);
    private static final Color HEADER_END = new Color(13, 148, 136);
    private static final Color SKY = new Color(2, 132, 199);
    private static final Color AMBER = new Color(217, 119, 6);
    private static final Color BG = new Color(241, 245, 249);
    private static final Color CARD = Color.WHITE;
    private static final Color BORDER = new Color(226, 232, 240);
    private static final Color INK = new Color(15, 23, 42);
    private static final Color MUTED = new Color(100, 116, 139);
    private static final Color FAINT = new Color(148, 163, 184);
    private static final Color SUCCESS = new Color(22, 163, 74);
    private static final Color DANGER = new Color(220, 38, 38);
    private static final Color CHART_NET = new Color(204, 251, 241);
    private static final Color CHART_TAX = new Color(245, 158, 11);

    private final JTextField priceField = new JTextField();
    private final JLabel taxValue = new JLabel("\u2014");
    private final JLabel withTaxValue = new JLabel("\u2014");
    private final JLabel fromTotalValue = new JLabel("\u2014");
    private final StatusBanner statusBanner = new StatusBanner();
    private final TaxChart chart = new TaxChart();

    public TaxSwing() {
        setTitle("Tax Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setMinimumSize(new Dimension(960, 700));

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BG);
        root.add(createHeaderPanel(), BorderLayout.NORTH);
        root.add(createBodyPanel(), BorderLayout.CENTER);

        setContentPane(root);
        setSize(1100, 740);
        setLocationRelativeTo(null);

        statusBanner.setMessage("Enter a price to see the three calculations at once.", PRIMARY);
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout(24, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new GradientPaint(0, 0, HEADER_START, getWidth(), getHeight(), HEADER_END));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(new Color(255, 255, 255, 16));
                g2.fillOval(getWidth() - 230, -90, 280, 280);
                g2.dispose();
            }
        };
        header.setOpaque(false);
        header.setBorder(new EmptyBorder(18, 28, 18, 28));

        JPanel texts = new JPanel();
        texts.setOpaque(false);
        texts.setLayout(new BoxLayout(texts, BoxLayout.Y_AXIS));

        JLabel badge = new JLabel("EXERCISE 14.07");
        badge.setFont(new Font("Segoe UI", Font.BOLD, 10));
        badge.setForeground(new Color(204, 251, 241));
        badge.setBorder(new CompoundBorder(
                new LineBorder(new Color(153, 246, 228, 120), 1, true),
                new EmptyBorder(3, 10, 3, 10)));
        badge.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("Tax Calculator");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel("One price, three calculations: VAT, price with VAT and VAT inside a total");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setForeground(new Color(204, 251, 241));
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        texts.add(badge);
        texts.add(Box.createVerticalStrut(7));
        texts.add(title);
        texts.add(Box.createVerticalStrut(3));
        texts.add(subtitle);

        header.add(texts, BorderLayout.CENTER);
        header.add(chart, BorderLayout.EAST);

        return header;
    }

    private JPanel createBodyPanel() {
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBackground(BG);
        body.setBorder(new EmptyBorder(16, 26, 20, 26));

        body.add(createInputCard());
        body.add(Box.createVerticalStrut(12));
        body.add(statusBanner);
        body.add(Box.createVerticalStrut(12));
        body.add(createResultsPanel());
        body.add(Box.createVerticalGlue());

        return body;
    }

    private JPanel createInputCard() {
        Card card = new Card(new BorderLayout(0, 12));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 196));

        JPanel head = new JPanel(new BorderLayout(12, 0));
        head.setOpaque(false);
        head.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("Enter a price");
        title.setFont(new Font("Segoe UI", Font.BOLD, 15));
        title.setForeground(INK);

        JLabel rate = new JLabel("VAT " + formatRate() + "%");
        rate.setFont(new Font("Segoe UI", Font.BOLD, 11));
        rate.setForeground(PRIMARY_DARK);
        rate.setBorder(new CompoundBorder(
                new LineBorder(new Color(153, 246, 228), 1, true),
                new EmptyBorder(3, 10, 3, 10)));

        head.add(title, BorderLayout.WEST);
        head.add(rate, BorderLayout.EAST);
        card.add(head, BorderLayout.NORTH);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setOpaque(false);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        priceLabel.setForeground(MUTED);
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        priceLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 16));

        priceField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        priceField.setForeground(INK);
        priceField.setBackground(new Color(248, 250, 252));
        priceField.setCaretColor(PRIMARY);
        priceField.setBorder(fieldBorder(BORDER));
        priceField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 46));
        priceField.setAlignmentX(Component.LEFT_ALIGNMENT);
        priceField.addActionListener(e -> calculate());
        priceField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                priceField.setBorder(fieldBorder(PRIMARY));
            }

            @Override
            public void focusLost(FocusEvent e) {
                priceField.setBorder(fieldBorder(BORDER));
            }
        });

        fieldPanel.add(priceLabel);
        fieldPanel.add(Box.createVerticalStrut(6));
        fieldPanel.add(priceField);
        card.add(fieldPanel, BorderLayout.CENTER);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        actions.setOpaque(false);
        actions.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton calculateButton = createButton("Calculate", PRIMARY, Color.WHITE, false);
        JButton clearButton = createButton("Clear", MUTED, MUTED, true);
        JButton exampleButton = createButton("Load example", PRIMARY, PRIMARY, true);

        calculateButton.addActionListener(e -> calculate());
        clearButton.addActionListener(e -> clearAll());
        exampleButton.addActionListener(e -> loadExample());

        actions.add(calculateButton);
        actions.add(clearButton);
        actions.add(exampleButton);
        card.add(actions, BorderLayout.SOUTH);

        return card;
    }

    private JPanel createResultsPanel() {
        JPanel results = new JPanel(new GridLayout(1, 3, 14, 0));
        results.setOpaque(false);
        results.setAlignmentX(Component.LEFT_ALIGNMENT);
        results.setMaximumSize(new Dimension(Integer.MAX_VALUE, 170));

        String rate = formatRate();
        String totalRate = String.format(Locale.UK, "%.0f", 100 + Tax.TAX);

        results.add(createResultCard("Tax from price",
                "price \u00D7 " + rate + " / 100", taxValue, PRIMARY));
        results.add(createResultCard("Price with tax",
                "price + tax(price)", withTaxValue, SKY));
        results.add(createResultCard("Tax from a total",
                "total \u00D7 " + rate + " / " + totalRate, fromTotalValue, AMBER));

        return results;
    }

    private JPanel createResultCard(String title, String formula, JLabel valueLabel, Color accent) {
        Card card = new Card(new BorderLayout(0, 2));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        titleLabel.setForeground(MUTED);

        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(accent);

        JLabel formulaLabel = new JLabel(formula);
        formulaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        formulaLabel.setForeground(FAINT);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        card.add(formulaLabel, BorderLayout.SOUTH);

        return card;
    }

    private void calculate() {
        String text = priceField.getText().trim().replace(',', '.');
        if (text.isEmpty()) {
            fail("Enter a price.", priceField);
            return;
        }

        float price;
        try {
            price = Float.parseFloat(text);
        } catch (NumberFormatException ex) {
            fail("'" + priceField.getText().trim() + "' is not a valid price.", priceField);
            return;
        }

        if (!Float.isFinite(price)) {
            fail("'" + priceField.getText().trim() + "' is not a valid price.", priceField);
            return;
        }

        if (price < 0) {
            fail("Price cannot be negative.", priceField);
            return;
        }

        float taxAmount = Tax.tax(price);
        float withTax = Tax.priceWithTax(price);
        float taxFromTotal = Tax.getTaxFromPrice(price);

        taxValue.setText(money(taxAmount));
        taxValue.setForeground(PRIMARY);
        withTaxValue.setText(money(withTax));
        withTaxValue.setForeground(SKY);
        fromTotalValue.setText(money(taxFromTotal));
        fromTotalValue.setForeground(AMBER);

        statusBanner.setMessage(
                "Calculated for " + money(price) + " \u00B7 VAT " + formatRate() + "%",
                SUCCESS);
    }

    private void clearAll() {
        priceField.setText("");
        priceField.setBorder(fieldBorder(BORDER));
        resetResults();
        statusBanner.setMessage("Enter a price to see the three calculations at once.", PRIMARY);
        priceField.requestFocus();
    }

    private void loadExample() {
        priceField.setText("1000");
        calculate();
    }

    private void resetResults() {
        taxValue.setText("\u2014");
        taxValue.setForeground(PRIMARY);
        withTaxValue.setText("\u2014");
        withTaxValue.setForeground(SKY);
        fromTotalValue.setText("\u2014");
        fromTotalValue.setForeground(AMBER);
    }

    private void fail(String message, JTextField field) {
        resetResults();
        statusBanner.setMessage(message, DANGER);
        field.requestFocus();
        field.selectAll();
    }

    private String formatRate() {
        return String.format(Locale.UK, "%.1f", Tax.TAX);
    }

    private static String money(float value) {
        return String.format(Locale.UK, "%.2f", value);
    }

    private Border fieldBorder(Color color) {
        return new CompoundBorder(
                new LineBorder(color, 1, true),
                new EmptyBorder(10, 12, 10, 12));
    }

    private JButton createButton(String text, Color color, Color foreground, boolean outline) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = getWidth();
                int h = getHeight();
                int arc = 12;

                if (outline) {
                    if (isEnabled() && getModel().isRollover()) {
                        g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 18));
                        g2.fillRoundRect(0, 0, w - 1, h - 1, arc, arc);
                    }
                    g2.setColor(isEnabled() ? color : FAINT);
                    g2.setStroke(new BasicStroke(1.5f));
                    g2.drawRoundRect(1, 1, w - 3, h - 3, arc, arc);
                } else {
                    Color base = isEnabled() ? color : FAINT;
                    if (isEnabled() && getModel().isPressed()) {
                        base = color.darker();
                    } else if (isEnabled() && getModel().isRollover()) {
                        base = color.brighter();
                    }
                    g2.setColor(new Color(0, 0, 0, 26));
                    g2.fillRoundRect(0, 3, w, h - 3, arc, arc);
                    g2.setColor(base);
                    g2.fillRoundRect(0, 0, w, h - 3, arc, arc);
                }

                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setForeground(foreground);
        button.setBorder(new EmptyBorder(9, 20, 11, 20));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setRolloverEnabled(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            TaxSwing app = new TaxSwing();
            app.setVisible(true);
        });
    }

    private static final class Card extends JPanel {

        Card(LayoutManager layout) {
            super(layout);
            setOpaque(false);
            setBorder(new EmptyBorder(16, 18, 16, 18));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            g2.setColor(new Color(15, 23, 42, 20));
            g2.fillRoundRect(3, 5, w - 6, h - 7, 20, 20);

            g2.setColor(CARD);
            g2.fillRoundRect(0, 0, w - 6, h - 7, 20, 20);

            g2.setColor(BORDER);
            g2.setStroke(new BasicStroke(1f));
            g2.drawRoundRect(0, 0, w - 7, h - 8, 20, 20);

            g2.dispose();
        }
    }

    private static final class StatusBanner extends JPanel {

        private final JLabel label = new JLabel("", SwingConstants.CENTER);
        private Color accent = PRIMARY;

        StatusBanner() {
            setOpaque(false);
            setLayout(new BorderLayout());
            setBorder(new EmptyBorder(11, 16, 11, 16));
            setAlignmentX(Component.LEFT_ALIGNMENT);
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
            label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            add(label, BorderLayout.CENTER);
        }

        void setMessage(String text, Color accent) {
            this.accent = accent;
            label.setText(text);
            label.setForeground(accent.darker());
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            g2.setColor(mix(accent, Color.WHITE, 0.12));
            g2.fillRoundRect(0, 0, w - 1, h - 1, 12, 12);

            g2.setColor(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 90));
            g2.setStroke(new BasicStroke(1f));
            g2.drawRoundRect(0, 0, w - 2, h - 2, 12, 12);

            g2.dispose();
        }

        private static Color mix(Color a, Color b, double ratio) {
            int r = (int) Math.round(a.getRed() * ratio + b.getRed() * (1 - ratio));
            int g = (int) Math.round(a.getGreen() * ratio + b.getGreen() * (1 - ratio));
            int bl = (int) Math.round(a.getBlue() * ratio + b.getBlue() * (1 - ratio));
            return new Color(r, g, bl);
        }
    }

    private static final class TaxChart extends JPanel {

        TaxChart() {
            setOpaque(false);
            setPreferredSize(new Dimension(150, 130));
            setMinimumSize(new Dimension(130, 120));
            setMaximumSize(new Dimension(160, 140));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            g2.setColor(new Color(255, 255, 255, 34));
            g2.fillRoundRect(0, 0, w - 1, h - 1, 18, 18);

            g2.setColor(new Color(255, 255, 255, 80));
            g2.setStroke(new BasicStroke(1f));
            g2.drawRoundRect(0, 0, w - 1, h - 1, 18, 18);

            int diameter = Math.min(100, Math.min(w, h) - 24);
            int cx = (w - diameter) / 2;
            int cy = (h - diameter) / 2;

            g2.setStroke(new BasicStroke(12f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(new Color(204, 251, 241, 70));
            g2.drawArc(cx, cy, diameter, diameter, 0, 360);

            float fraction = Math.min(Tax.TAX / 100f, 1f);
            g2.setColor(CHART_TAX);
            g2.drawArc(cx, cy, diameter, diameter, 90, -Math.round(360f * fraction));

            String percent = String.format(Locale.UK, "%.0f%%", Tax.TAX);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 16));
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(percent, cx + (diameter - fm.stringWidth(percent)) / 2,
                    cy + diameter / 2 + fm.getAscent() / 2 - 2);

            g2.setFont(new Font("Segoe UI", Font.BOLD, 8));
            FontMetrics fmSmall = g2.getFontMetrics();
            String caption = "VAT";
            g2.setColor(CHART_NET);
            g2.drawString(caption, cx + (diameter - fmSmall.stringWidth(caption)) / 2,
                    cy + diameter / 2 + fm.getAscent() / 2 + 12);

            g2.dispose();
        }
    }
}