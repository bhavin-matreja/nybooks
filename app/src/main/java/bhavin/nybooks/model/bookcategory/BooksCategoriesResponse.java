package bhavin.nybooks.model.bookcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bhavin on 4/20/2018.
 */

public class BooksCategoriesResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private int numResults;
    @SerializedName("results")
    @Expose
    private ArrayList<CategoryListModel> results = null;

    /**
     *
     * @param results
     * @param status
     * @param numResults
     * @param copyright
     */
    public BooksCategoriesResponse(String status, String copyright, int numResults, ArrayList<CategoryListModel> results) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.numResults = numResults;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public ArrayList<CategoryListModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<CategoryListModel> results) {
        this.results = results;
    }


}
