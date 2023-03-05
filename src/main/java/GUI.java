import javax.swing.*;

public class GUI{

    public GUI(){
        JTextField FromField = new JTextField(5);
        JTextField ToField = new JTextField(5);
        JTextField AmountField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("From:"));
        myPanel.add(FromField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("To:"));
        myPanel.add(ToField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Amount:"));
        myPanel.add(AmountField);


        int selected = JOptionPane.showConfirmDialog(
                null,
                myPanel,
                "Currency Converter",
                JOptionPane.OK_CANCEL_OPTION);

        if (selected == JOptionPane.OK_OPTION){
            String from = FromField.getText();
            String to = ToField.getText();
            double amount = 0.0;

            try{
                amount = Double.parseDouble(AmountField.getText());
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input isn't a valid number: " + e.getMessage(), "Failed", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            }


            try {
                Double result = CurrencyConverter.convert(from, to, amount);
                JOptionPane.showMessageDialog(null, "Converted amount: " + result.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Failed", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

}
