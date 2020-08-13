import javax.print.DocFlavor;
import javax.swing.*;

/**
 * An add controller of the product inventory application.
 *
 * <p>CS18000 -- Fall 2018 -- Complex GUIs -- Homework</p>
 *
 * @author Avarokin Raj Saini, lab sec 8
 * @version November 13, 2018
 */
public final class AddController {
    /**
     * The inventory model of this add controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The add view of this add controller.
     */
    private AddView addView;

    /**
     * Constructs a newly allocated {@code AddController} object with the specified inventory model and add view.
     *
     * @param inventoryModel the inventory model to be used in construction
     * @param addView        the add view to be used in construction
     * @throws IllegalArgumentException if the specified inventory model or add view is {@code null}
     */
    public AddController(InventoryModel inventoryModel, AddView addView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("the specified inventory model is null");
        } else if (addView == null) {
            throw new IllegalArgumentException("the specified add view is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.addView = addView;

            this.addView.getAddButton()
                    .addActionListener(e -> this.invokeAddButtonSemantics());

            this.addView.getClearButton()
                    .addActionListener(e -> this.invokeClearButtonSemantics());
        } //end if
    } //AddController

    /**
     * Invokes the add button semantics for this add controller's add view.
     */
    private void invokeAddButtonSemantics() {

        String sku = addView.getSkuTextField().getText();
        String name = addView.getNameTextField().getText();
        String wholesalePriceStr = addView.getWholesalePriceTextField().getText();
        String retailPriceString = addView.getRetailPriceTextField().getText();
        String quantityString = addView.getQuantityTextField().getText();

        double wholesalePrice = 0;
        double retailPrice = 0;
        int quantity = 0;

        try {
            wholesalePrice = Double.parseDouble(wholesalePriceStr);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "The specified wholesale price is not a number",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            retailPrice = Double.parseDouble(retailPriceString);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "The specified retail price is not a number",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            return;
        }


        try {
            quantity = Integer.parseInt(quantityString);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "The specified quantity is not a number",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = new Product(sku, name, wholesalePrice, retailPrice, quantity);

        if (!inventoryModel.contains(product)) {

            inventoryModel.add(product);

        } else {

            JOptionPane.showMessageDialog(null, "This product could not be added to the" +
                            " inventory!\nA product with the specified SKU already exists!",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
        }

        //
    } //invokeAddButtonSemantics

    /**
     * Invokes the clear button semantics for this add controller's add view.
     */
    private void invokeClearButtonSemantics() {

        addView.getSkuTextField().setText("");
        addView.getNameTextField().setText("");
        addView.getWholesalePriceTextField().setText("");
        addView.getRetailPriceTextField().setText("");
        addView.getQuantityTextField().setText("");
        addView.getSkuTextField().requestFocus();


        //
    } //invokeClearButtonSemantics

    /**
     * Returns the hash code of this add controller.
     *
     * @return the hash code of this add controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + ((this.inventoryModel == null) ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + ((this.addView == null) ? 0 : this.addView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not the specified object is equal to this add controller. {@code true} is returned if and
     * only if the specified object is an instance of {@code AddController} and its inventory model and add view are
     * equal to this add controller's.
     *
     * @param object the object to be used in the comparison
     * @return {@code true}, if the specified object is equal to this add controller and {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof AddController) {
            boolean isEqual;

            if (this.inventoryModel == null) {
                isEqual = ((AddController) object).inventoryModel == null;
            } else {
                isEqual = this.inventoryModel.equals(((AddController) object).inventoryModel);
            } //end if

            if (this.addView == null) {
                isEqual &= ((AddController) object).addView == null;
            } else {
                isEqual &= this.addView.equals(((AddController) object).addView);
            } //end if

            return isEqual;
        } else {
            return false;
        } //end if
    } //equals

    /**
     * Returns the {@code String} representation of this add controller. The returned {@code String} is of the form
     * {@code AddController[inventoryModel = inventoryModel_value, addView = addView_value]}.
     *
     * @return the {@code String} representation of this add controller
     */
    @Override
    public String toString() {
        String format = "AddController[inventoryModel = %s, addView = %s]";

        return String.format(format, this.inventoryModel, this.addView);
    } //toString
}