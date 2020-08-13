import javax.swing.*;

/**
 * A remove controller of the product inventory application.
 *
 * <p>CS18000 -- Fall 2018 -- Complex GUIs -- Homework</p>
 *
 * @author Avarokin Raj Saini, lab sec 8
 * @version November 13, 2018
 */
public final class RemoveController {
    /**
     * The inventory model of this remove controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The remove view of this remove controller.
     */
    private RemoveView removeView;

    /**
     * Constructs a newly allocated {@code RemoveController} object with the specified inventory model and remove view.
     *
     * @param inventoryModel the inventory model to be used in construction
     * @param removeView     the remove view to be used in construction
     * @throws IllegalArgumentException if the specified inventory model or remove view is {@code null}
     */
    public RemoveController(InventoryModel inventoryModel, RemoveView removeView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("the specified inventory model is null");
        } else if (removeView == null) {
            throw new IllegalArgumentException("the specified remove view is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.removeView = removeView;

            this.removeView.getRemoveButton()
                    .addActionListener(e -> this.invokeRemoveButtonSemantics());

            this.removeView.getClearButton()
                    .addActionListener(e -> this.invokeClearButtonSemantics());
        } //end if
    } //RemoveController

    /**
     * Invokes the remove button semantics for this remove controller's remove view.
     */
    private void invokeRemoveButtonSemantics() {

        String sku = removeView.getSkuTextField().getText();

        if (inventoryModel.searchBySku(sku) == null) {
            JOptionPane.showMessageDialog(null, "A product with the specified SKU does not exist" +
                    " in the inventory!", "Product Inventory", JOptionPane.ERROR_MESSAGE);

            removeView.getSkuTextField().requestFocus();

        } else {
            inventoryModel.remove(inventoryModel.searchBySku(sku));

            JOptionPane.showMessageDialog(null, "This product has been removed from the" +
                    " inventory.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
        }

        //
    } //invokeRemoveButtonSemantics

    /**
     * Invokes the clear button semantics for this remove controller's remove view.
     */
    private void invokeClearButtonSemantics() {

        removeView.getSkuTextField().setText("");
        removeView.getSkuTextField().requestFocus();
        //
    } //invokeClearButtonSemantics

    /**
     * Returns the hash code of this remove controller.
     *
     * @return the hash code of this remove controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + ((this.inventoryModel == null) ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + ((this.removeView == null) ? 0 : this.removeView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not the specified object is equal to this remove controller. {@code true} is returned if
     * and only if the specified object is an instance of {@code RemoveController} and its inventory model and remove
     * view are equal to this remove controller's.
     *
     * @param object the object to be used in the comparison
     * @return {@code true}, if the specified object is equal to this remove controller and {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof RemoveController) {
            boolean isEqual;

            if (this.inventoryModel == null) {
                isEqual = ((RemoveController) object).inventoryModel == null;
            } else {
                isEqual = this.inventoryModel.equals(((RemoveController) object).inventoryModel);
            } //end if

            if (this.removeView == null) {
                isEqual &= ((RemoveController) object).removeView == null;
            } else {
                isEqual &= this.removeView.equals(((RemoveController) object).removeView);
            } //end if

            return isEqual;
        } else {
            return false;
        } //end if
    } //equals

    /**
     * Returns the {@code String} representation of this remove controller. The returned {@code String} is of the form
     * {@code RemoveController[inventoryModel = inventoryModel_value, removeView = removeView_value]}.
     *
     * @return the {@code String} representation of this remove controller
     */
    @Override
    public String toString() {
        String format = "RemoveController[inventoryModel = %s, removeView = %s]";

        return String.format(format, this.inventoryModel, this.removeView);
    } //toString
}