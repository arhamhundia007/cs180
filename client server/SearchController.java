import javax.swing.*;

/**
 * A search controller of the product inventory application.
 *
 * <p>CS18000 -- Fall 2018 -- Complex GUIs -- Homework</p>
 *
 * @author Avarokin Raj Saini, lab sec 8
 * @version November 13, 2018
 */
public final class SearchController {
    /**
     * The inventory model of this search controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The search view of this search controller.
     */
    private SearchView searchView;

    /**
     * Constructs a newly allocated {@code SearchController} object with the specified inventory model and search view.
     *
     * @param inventoryModel the inventory model to be used in construction
     * @param searchView     the search view to be used in construction
     * @throws IllegalArgumentException if the specified inventory model or search view is {@code null}
     */
    public SearchController(InventoryModel inventoryModel, SearchView searchView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("the specified inventory model is null");
        } else if (searchView == null) {
            throw new IllegalArgumentException("the specified search view is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.searchView = searchView;

            this.searchView.getSearchButton()
                    .addActionListener(e -> this.invokeSearchButtonSemantics());

            this.searchView.getClearButton()
                    .addActionListener(e -> this.invokeClearButtonSemantics());
        } //end if
    } //SearchController

    /**
     * Invokes the search button semantics for this search controller's search view.
     */
    private void invokeSearchButtonSemantics() {

        if (searchView.getFieldComboBox().getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a field!", "Product Inventory",
                    JOptionPane.ERROR_MESSAGE);
        }

        int index = searchView.getFieldComboBox().getSelectedIndex();
        String field = searchView.getSearchValueTextField().getText();

        switch (index) {

            case 0:

                searchView.getResultsTextArea().setText(inventoryModel.searchBySku(field).toString());
                break;

            case 1:

                searchView.getResultsTextArea().setText(inventoryModel.searchByName(field).toString());
                break;


            case 2:

                try {
                    double wholesalePrice = Double.parseDouble(field);
                    searchView.getResultsTextArea().setText(
                            inventoryModel.searchByWholesalePrice(wholesalePrice).toString());


                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "The specified search value" +
                            " is not a valid number", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                }

                break;

            case 3:

                try {
                    double retailPrice = Double.parseDouble(field);
                    searchView.getResultsTextArea().setText(
                            inventoryModel.searchByRetailPrice(retailPrice).toString());


                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "The specified search value" +
                            " is not a valid number", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                }

                break;

            case 4:

                try {
                    int quantity = Integer.parseInt(field);
                    searchView.getResultsTextArea().setText(
                            inventoryModel.searchByQuantity(quantity).toString());


                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "The specified search value" +
                            " is not a valid number", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    break;
                }

                break;


        }


        //
    } //invokeSearchButtonSemantics

    /**
     * Invokes the clear button semantics for this search controller's search view.
     */
    private void invokeClearButtonSemantics() {

        searchView.getResultsTextArea().setText("");
        searchView.getFieldComboBox().setSelectedIndex(-1);
        searchView.getSearchValueTextField().setText("");
        searchView.getSearchValueTextField().requestFocus();
        //
    } //invokeClearButtonSemantics

    /**
     * Returns the hash code of this search controller.
     *
     * @return the hash code of this search controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + ((this.inventoryModel == null) ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + ((this.searchView == null) ? 0 : this.searchView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not the specified object is equal to this search controller. {@code true} is returned if
     * and only if the specified object is an instance of {@code SearchController} and its inventory model and search
     * view are equal to this search controller's.
     *
     * @param object the object to be used in the comparison
     * @return {@code true}, if the specified object is equal to this search controller and {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof SearchController) {
            boolean isEqual;

            if (this.inventoryModel == null) {
                isEqual = ((SearchController) object).inventoryModel == null;
            } else {
                isEqual = this.inventoryModel.equals(((SearchController) object).inventoryModel);
            } //end if

            if (this.searchView == null) {
                isEqual &= ((SearchController) object).searchView == null;
            } else {
                isEqual &= this.searchView.equals(((SearchController) object).searchView);
            } //end if

            return isEqual;
        } else {
            return false;
        } //end if
    } //equals

    /**
     * Returns the {@code String} representation of this search controller. The returned {@code String} is of the form
     * {@code SearchController[inventoryModel = inventoryModel_value, searchView = searchView_value]}.
     *
     * @return the {@code String} representation of this search controller
     */
    @Override
    public String toString() {
        String format = "SearchController[inventoryModel = %s, searchView = %s]";

        return String.format(format, this.inventoryModel, this.searchView);
    } //toString
}