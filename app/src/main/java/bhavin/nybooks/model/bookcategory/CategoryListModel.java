package bhavin.nybooks.model.bookcategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Bhavin on 4/25/2018.
 */

@DatabaseTable(tableName = "bookcategories")
public class CategoryListModel {

        @SerializedName("list_name")
        @Expose
        @DatabaseField(columnName = "list_name")
        private String listName;
        @SerializedName("display_name")
        @Expose
        @DatabaseField(columnName = "display_name")
        private String displayName;
        @SerializedName("list_name_encoded")
        @Expose
        @DatabaseField(columnName = "list_name_encoded")
        private String listNameEncoded;
        @SerializedName("oldest_published_date")
        @Expose
        @DatabaseField(columnName = "oldest_published_date")
        private String oldestPublishedDate;
        @SerializedName("newest_published_date")
        @Expose
        @DatabaseField(columnName = "newest_published_date")
        private String newestPublishedDate;
        @SerializedName("updated")
        @Expose
        @DatabaseField(columnName = "updated")
        private String updated;

        public CategoryListModel() {
        }

        /**
         *
         * @param newestPublishedDate
         * @param listNameEncoded
         * @param listName
         * @param updated
         * @param displayName
         * @param oldestPublishedDate
         */
        public CategoryListModel(String listName, String displayName, String listNameEncoded, String oldestPublishedDate, String newestPublishedDate, String updated) {
            super();
            this.listName = listName;
            this.displayName = displayName;
            this.listNameEncoded = listNameEncoded;
            this.oldestPublishedDate = oldestPublishedDate;
            this.newestPublishedDate = newestPublishedDate;
            this.updated = updated;
        }

        public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getListNameEncoded() {
            return listNameEncoded;
        }

        public void setListNameEncoded(String listNameEncoded) {
            this.listNameEncoded = listNameEncoded;
        }

        public String getOldestPublishedDate() {
            return oldestPublishedDate;
        }

        public void setOldestPublishedDate(String oldestPublishedDate) {
            this.oldestPublishedDate = oldestPublishedDate;
        }

        public String getNewestPublishedDate() {
            return newestPublishedDate;
        }

        public void setNewestPublishedDate(String newestPublishedDate) {
            this.newestPublishedDate = newestPublishedDate;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }


}
