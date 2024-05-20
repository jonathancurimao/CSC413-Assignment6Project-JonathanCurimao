package Assignment6View;
import Assignment6Controller.CustomerAddressDTO;
import Assignment6Model.CustomerAddress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Assignment6Controller.CustomerDTO;

public class CustomerAddressFrame extends javax.swing.JFrame {
    private CustomerAddress address;
    private JTextField streetNumField;
    private JTextField streetNameField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    private JButton saveButton;
    private JButton cancelButton;

    public CustomerAddressFrame (CustomerAddress address) {
        this.address = address;
        initComponents();
        populateAddressDetails();
    }

    private void initComponents() {
        JLabel streetNumLabel = new JLabel("Street Number:");
        JLabel streetNameLabel = new JLabel("Street Name:");
        JLabel cityLabel = new JLabel("City:");
        JLabel stateLabel = new JLabel("State:");
        JLabel zipLabel = new JLabel("ZIP Code:");

        streetNumField = new JTextField();
        streetNameField = new JTextField();
        cityField = new JTextField();
        stateField = new JTextField();
        zipField = new JTextField();

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveCustomerAddress();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        // Layout setup
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(saveButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(streetNumLabel)
                                                        .addComponent(streetNameLabel)
                                                        .addComponent(cityLabel)
                                                        .addComponent(stateLabel)
                                                        .addComponent(zipLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(streetNumField)
                                                        .addComponent(streetNameField)
                                                        .addComponent(cityField)
                                                        .addComponent(stateField)
                                                        .addComponent(zipField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(streetNumLabel)
                                        .addComponent(streetNumField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(streetNameLabel)
                                        .addComponent(streetNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cityLabel)
                                        .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(stateLabel)
                                        .addComponent(stateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(zipLabel)
                                        .addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveButton)
                                        .addComponent(cancelButton))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void populateAddressDetails() {
        streetNumField.setText(String.valueOf(address.getStreetNum()));
        streetNameField.setText(address.getStreetName());
        cityField.setText(address.getCity());
        stateField.setText(address.getState());
        zipField.setText(String.valueOf(address.getZip()));
    }

    private void saveCustomerAddress() {
            address.setStreetNum(Integer.parseInt(streetNumField.getText()));
            address.setCity(cityField.getText());
            address.setState(stateField.getText());
            address.setZip(Integer.parseInt(zipField.getText()));

            // Save the updated address to the database
            int result = CustomerAddressDTO.performUpdate(address);
            if (result != -1) {
                JOptionPane.showMessageDialog(this, "Address updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update address.");
            }
        }


        public static void main (String args[]){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CustomerAddressFrame(new CustomerAddress()).setVisible(true);
                }
            });
        }
    }


