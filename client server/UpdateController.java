import javax.swing.*;

/**
 * An update controller of the product inventory application.
 *
 * <p>CS18000 -- Fall 2018 -- Complex GUIs -- Homework</p>
 *
 * @author Avarokin Raj Saini, lab sec 8
 * @version November 13, 2018
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
     * @param inventoryModel the inventory model to be used in construction
     * @param updateView     the update view to be used in construction
     * @throws IllegalArgumentException if the specified inventory model or update view is {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("the specified inventory model is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("the specified update view is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton()
                    .addActionListener(e -> this.invokeUpdateButtonSemantics());

            this.updateView.getClearButton()
                    .addActionListener(e -> this.invokeClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Invokes the update button semantics for this update controller's update view.
     */
    private void invokeUpdateButtonSemantics() {

        String sku = updateView.getSkuTextField().getText();
        String nfv = updateView.getNewFieldValueTextField().getText();
        int index = updateView.getFieldComboBox().getSelectedIndex();


        if (inventoryModel.searchBySku(sku) == null) {
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

        switch (index) {

            case 0:
                inventoryModel.searchBySku(sku).setSku(nfv);

                JOptionPane.showMessageDialog(null, "This product's SKU has" +
                        " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                break;

            case 1:
                inventoryModel.searchBySku(sku).setName(nfv);

                JOptionPane.showMessageDialog(null, "This product's name has" +
                        " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);

                break;

            case 2:

                try {
                    double wholesalePrice = Double.parseDouble(nfv);
                    inventoryModel.searchBySku(sku).setWholesalePrice(wholesalePrice);

                    JOptionPane.showMessageDialog(null, "This product's wholesale price has" +
                            " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);


                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "This product's wholesale price" +
                                    " could not be updated!\nThe specified wholesale price is not a valid number!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);

                }

                break;


            case 3:

                try {
                    double retailPrice = Double.parseDouble(nfv);
                    inventoryModel.searchBySku(sku).setRetailPrice(retailPrice);

                    JOptionPane.showMessageDialog(null, "This product's retail price has" +
                            " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);


                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "This product's retail price could" +
                                    " not be updated!\nThe specified retail price is not a valid number!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);

                }

                break;


            case 4:

                try {
                    int quantity = Integer.parseInt(nfv);
                    inventoryModel.searchBySku(sku).setQuantity(quantity);

                    JOptionPane.showMessageDialog(null, "This product's quantity has" +
                            " been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);


                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "This product's quantity could" +
                                    " not be updated!\nThe specified quantity is not a valid number!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);

                }

                break;

        }


        //
    } //invokeUpdateButtonSemantics

    /**
     * Invokes the clear button semantics for this update controller's update view.
     */
    private void invokeClearButtonSemantics() {

        updateView.getSkuTextField().setText("");
        updateView.getNewFieldValueTextField().setText("");
        updateView.getFieldComboBox().setSelectedIndex(-1);
        updateView.getSkuTextField().requestFocus();

        //
    } //invokeClearButtonSemantics

    /**
     * Returns the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + ((this.inventoryModel == null) ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + ((this.updateView == null) ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not the specified object is equal to this update controller. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController} and its inventory model and update
     * view are equal to this update controller's.
     *
     * @param object the object to be used in the comparison
     * @return {@code true}, if the specified object is equal to this update controller and {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof UpdateController) {
            boolean isEqual;

            if (this.inventoryModel == null) {
                isEqual = ((UpdateController) object).inventoryModel == null;
            } else {
                isEqual = this.inventoryModel.equals(((UpdateController) object).inventoryModel);
            } //end if

            if (this.updateView == null) {
                isEqual &= ((UpdateController) object).updateView == null;
            } else {
                isEqual &= this.updateView.equals(((UpdateController) object).updateView);
            } //end if

            return isEqual;
        } else {
            return false;
        } //end if
    } //equals

    /**
     * Returns the {@code String} representation of this update controller. The returned {@code String} is of the form
     * {@code UpdateController[inventoryModel = inventoryModel_value, updateView = updateView_value]}.
     *
     * @return the {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        String format = "UpdateController[inventoryModel = %s, updateView = %s]";

        return String.format(format, this.inventoryModel, this.updateView);
    } //toString
}