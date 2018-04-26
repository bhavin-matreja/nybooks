package bhavin.nybooks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bhavin on 4/23/2018.
 */

public class BooksListByNameResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("last_modified")
    @Expose
    private String lastModified;
    @SerializedName("results")
    @Expose
    private Results results;

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

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public class Results {

        @SerializedName("list_name")
        @Expose
        private String listName;
        @SerializedName("list_name_encoded")
        @Expose
        private String listNameEncoded;
        @SerializedName("bestsellers_date")
        @Expose
        private String bestsellersDate;
        @SerializedName("published_date")
        @Expose
        private String publishedDate;
        @SerializedName("published_date_description")
        @Expose
        private String publishedDateDescription;
        @SerializedName("next_published_date")
        @Expose
        private String nextPublishedDate;
        @SerializedName("previous_published_date")
        @Expose
        private String previousPublishedDate;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("normal_list_ends_at")
        @Expose
        private Integer normalListEndsAt;
        @SerializedName("updated")
        @Expose
        private String updated;
        @SerializedName("books")
        @Expose
        private ArrayList<Book> books = null;

        public String getListName() {
            return listName;
        }

        public String getListNameEncoded() {
            return listNameEncoded;
        }

        public String getBestsellersDate() {
            return bestsellersDate;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public String getPublishedDateDescription() {
            return publishedDateDescription;
        }

        public String getNextPublishedDate() {
            return nextPublishedDate;
        }

        public String getPreviousPublishedDate() {
            return previousPublishedDate;
        }

        public String getDisplayName() {
            return displayName;
        }

        public Integer getNormalListEndsAt() {
            return normalListEndsAt;
        }

        public String getUpdated() {
            return updated;
        }

        public ArrayList<Book> getBooks() {
            return books;
        }
    }

    public class Book {

        @SerializedName("rank")
        @Expose
        private Integer rank;
        @SerializedName("rank_last_week")
        @Expose
        private Integer rankLastWeek;
        @SerializedName("weeks_on_list")
        @Expose
        private Integer weeksOnList;
        @SerializedName("asterisk")
        @Expose
        private Integer asterisk;
        @SerializedName("dagger")
        @Expose
        private Integer dagger;
        @SerializedName("primary_isbn10")
        @Expose
        private String primaryIsbn10;
        @SerializedName("primary_isbn13")
        @Expose
        private String primaryIsbn13;
        @SerializedName("publisher")
        @Expose
        private String publisher;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("contributor")
        @Expose
        private String contributor;
        @SerializedName("contributor_note")
        @Expose
        private String contributorNote;
        @SerializedName("book_image")
        @Expose
        private String bookImage;
        @SerializedName("book_image_width")
        @Expose
        private Integer bookImageWidth;
        @SerializedName("book_image_height")
        @Expose
        private Integer bookImageHeight;
        @SerializedName("amazon_product_url")
        @Expose
        private String amazonProductUrl;
        @SerializedName("age_group")
        @Expose
        private String ageGroup;
        @SerializedName("book_review_link")
        @Expose
        private String bookReviewLink;
        @SerializedName("first_chapter_link")
        @Expose
        private String firstChapterLink;
        @SerializedName("sunday_review_link")
        @Expose
        private String sundayReviewLink;
        @SerializedName("article_chapter_link")
        @Expose
        private String articleChapterLink;
        @SerializedName("isbns")
        @Expose
        private ArrayList<Isbn> isbns = null;
        @SerializedName("buy_links")
        @Expose
        private ArrayList<BuyLink> buyLinks = null;

        public Integer getRank() {
            return rank;
        }

        public Integer getRankLastWeek() {
            return rankLastWeek;
        }

        public Integer getWeeksOnList() {
            return weeksOnList;
        }

        public Integer getAsterisk() {
            return asterisk;
        }

        public Integer getDagger() {
            return dagger;
        }

        public String getPrimaryIsbn10() {
            return primaryIsbn10;
        }

        public String getPrimaryIsbn13() {
            return primaryIsbn13;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getDescription() {
            return description;
        }

        public Integer getPrice() {
            return price;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getContributor() {
            return contributor;
        }

        public String getContributorNote() {
            return contributorNote;
        }

        public String getBookImage() {
            return bookImage;
        }

        public Integer getBookImageWidth() {
            return bookImageWidth;
        }

        public Integer getBookImageHeight() {
            return bookImageHeight;
        }

        public String getAmazonProductUrl() {
            return amazonProductUrl;
        }

        public String getAgeGroup() {
            return ageGroup;
        }

        public String getBookReviewLink() {
            return bookReviewLink;
        }

        public String getFirstChapterLink() {
            return firstChapterLink;
        }

        public String getSundayReviewLink() {
            return sundayReviewLink;
        }

        public String getArticleChapterLink() {
            return articleChapterLink;
        }

        public ArrayList<Isbn> getIsbns() {
            return isbns;
        }

        public ArrayList<BuyLink> getBuyLinks() {
            return buyLinks;
        }
    }
    public class BuyLink {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

    }

    public class Isbn {

        @SerializedName("isbn10")
        @Expose
        private String isbn10;
        @SerializedName("isbn13")
        @Expose
        private String isbn13;

    }
}