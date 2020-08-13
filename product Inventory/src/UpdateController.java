import javax.swing.*;

/**
 * An update controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 */
public final class UpdateController {
    /**
     * The inventory model of this update controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The update view of this update controller.
     */
    private UpdateView updateView;

    /**
     * Constructs a newly allocated {@code UpdateController} object with the specified inventory model and update view.
     *
     * @param inventoryModel the inventory model of this update controller
     * @param updateView the update view of this update controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code updateView} argument is
     * {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("updateView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton().addActionListener(e -> this.getUpdateButtonSemantics());

            this.updateView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Gets the semantics of an update view's update button.
     */
    private void getUpdateButtonSemantics() {
        //TODO implement method
        String skuField = updateView.getSkuTextField().getText();
        String newField = updateView.getNewFieldValueTextField().getText();
        int choice = updateView.getFieldComboBox().getSelectedIndex();


        if (inventoryModel.searchBySku(skuField).isEmpty()) {
            JOptionPane.showMessageDialog(null, "A product with the specified SKU does not " +
                    "exist in this inventory!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (updateView.getFieldComboBox().getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "A field has not been selected to be updated!",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);

            updateView.getFieldComboBox().requestFocus();

            return;
        }

        switch (choice) {

            case 0: {

                inventoryModel.searchBySku(skuField).get().setSku(newField);  //updating sku info
                JOptionPane.showMessageDialog(null, "This product's SKU has" +
                            " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                break;
            }

            case 1: {

                inventoryModel.searchBySku(skuField).get().setName(newField);   //updating name info
                JOptionPane.showMessageDialog(null, "This product's name has" +
                        " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                break;
            }

            case 2: {

                try {
                    double wholeSale = Double.parseDouble(newField);

                    inventoryModel.searchBySku(skuField).get().setWholesalePrice(wholeSale);

                    JOptionPane.showMessageDialog(null, "This product's wholesale price has" +
                                " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                } catch (RuntimeException e) {

                    JOptionPane.showMessageDialog(null, "This product's wholesale price" +
                                    " could not be updated!\nThe specified wholesale price is not a valid number!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);

                }

                break;
            }

            case 3: {


                try {
                    double retail = Double.parseDouble(newField);

                    inventoryModel.searchBySku(skuField).get().setRetailPrice(retail);

                    JOptionPane.showMessageDialog(null, "This product's retail price has" +
                            " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                } catch (RuntimeException e) {

                    JOptionPane.showMessageDialog(null, "This product's retail price could" +
                                    " not be updated!\nThe specified retail price is not a valid number!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);

                }

                break;
            }

            case 4: {

                try {
                    int numOfItems = Integer.parseInt(newField);

                    inventoryModel.searchBySku(skuField).get().setQuantity(numOfItems);

                    JOptionPane.showMessageDialog(null, "This product's quantity has" +
                            " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {

                    JOptionPane.showMessageDialog( null,"This product's quantity could" +
                                    " not be updated!\nThe specified quantity is not a valid number!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);

                }

                break;
            }

            default: {
                throw new IllegalStateException("Unexpected value: " + choice);
            }
        }


    } //getUpdateButtonSemantics

    /**
     * Gets the semantics of an update view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method

        updateView.getSkuTextField().setText("");
        updateView.getNewFieldValueTextField().setText("");
        updateView.getFieldComboBox().setSelectedIndex(-1);
        updateView.getSkuTextField().requestFocus();

    } //getClearButtonSemantics

    /**
     * Gets the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController}, and its field values are equal to
     * this update controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateController)
                && (this.inventoryModel == null ? ((UpdateController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((UpdateController) anObject).inventoryModel))
                && (this.updateView == null ? ((UpdateController) anObject).updateView ==  null : this.updateView.equals(((UpdateController) anObject).updateView));
    } //equals

    /**
     * Gets a {@code String} representation of this update controller.
     *
     * @return a {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        return String.format("UpdateController[%s, %s]", this.inventoryModel, this.updateView);
    } //toString
}