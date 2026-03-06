package org.sysoev.task10;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WorkerNameView extends JFrame implements View {

    private final JTextField field = new JTextField();
    private final JButton button = new JButton("Clear");

    private final WorkerNameViewModel viewModel;

    public WorkerNameView(WorkerNameViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.initView(this);

        setLayout(new GridLayout(1, 1));

        add(field);
        add(button);

        field.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                viewModel.changeName(field.getText());
            }

            public void removeUpdate(DocumentEvent e) {
                viewModel.changeName(field.getText());
            }

            public void changedUpdate(DocumentEvent e) {
                viewModel.changeName(field.getText());
            }
        });

        button.addActionListener(e -> viewModel.clickButton());

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void view(String workerName, boolean enable) {

        if (!field.getText().equals(workerName)) {
            field.setText(workerName);
        }

        button.setEnabled(enable);
    }
}
