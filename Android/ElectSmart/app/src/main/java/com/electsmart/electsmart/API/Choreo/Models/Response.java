package com.electsmart.electsmart.API.Choreo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Response {

    @SerializedName("feed")
    @Expose
    private String feed;
    @SerializedName("identifiers")
    @Expose
    private List<Object> identifiers = new ArrayList<Object>();
    @SerializedName("dislikes")
    @Expose
    private Integer dislikes;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("userScore")
    @Expose
    private Integer userScore;
    @SerializedName("isSpam")
    @Expose
    private Boolean isSpam;
    @SerializedName("signedLink")
    @Expose
    private String signedLink;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("raw_message")
    @Expose
    private String rawMessage;
    @SerializedName("isClosed")
    @Expose
    private Boolean isClosed;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("forum")
    @Expose
    private String forum;
    @SerializedName("clean_title")
    @Expose
    private String cleanTitle;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("userSubscription")
    @Expose
    private Boolean userSubscription;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("highlightedPost")
    @Expose
    private Object highlightedPost;

    /**
     *
     * @return
     * The feed
     */
    public String getFeed() {
        return feed;
    }

    /**
     *
     * @param feed
     * The feed
     */
    public void setFeed(String feed) {
        this.feed = feed;
    }

    /**
     *
     * @return
     * The identifiers
     */
    public List<Object> getIdentifiers() {
        return identifiers;
    }

    /**
     *
     * @param identifiers
     * The identifiers
     */
    public void setIdentifiers(List<Object> identifiers) {
        this.identifiers = identifiers;
    }

    /**
     *
     * @return
     * The dislikes
     */
    public Integer getDislikes() {
        return dislikes;
    }

    /**
     *
     * @param dislikes
     * The dislikes
     */
    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    /**
     *
     * @return
     * The likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     * The likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The userScore
     */
    public Integer getUserScore() {
        return userScore;
    }

    /**
     *
     * @param userScore
     * The userScore
     */
    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    /**
     *
     * @return
     * The isSpam
     */
    public Boolean getIsSpam() {
        return isSpam;
    }

    /**
     *
     * @param isSpam
     * The isSpam
     */
    public void setIsSpam(Boolean isSpam) {
        this.isSpam = isSpam;
    }

    /**
     *
     * @return
     * The signedLink
     */
    public String getSignedLink() {
        return signedLink;
    }

    /**
     *
     * @param signedLink
     * The signedLink
     */
    public void setSignedLink(String signedLink) {
        this.signedLink = signedLink;
    }

    /**
     *
     * @return
     * The isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     *
     * @param isDeleted
     * The isDeleted
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     *
     * @return
     * The rawMessage
     */
    public String getRawMessage() {
        return rawMessage;
    }

    /**
     *
     * @param rawMessage
     * The raw_message
     */
    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    /**
     *
     * @return
     * The isClosed
     */
    public Boolean getIsClosed() {
        return isClosed;
    }

    /**
     *
     * @param isClosed
     * The isClosed
     */
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     *
     * @param slug
     * The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     *
     * @return
     * The forum
     */
    public String getForum() {
        return forum;
    }

    /**
     *
     * @param forum
     * The forum
     */
    public void setForum(String forum) {
        this.forum = forum;
    }

    /**
     *
     * @return
     * The cleanTitle
     */
    public String getCleanTitle() {
        return cleanTitle;
    }

    /**
     *
     * @param cleanTitle
     * The clean_title
     */
    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    /**
     *
     * @return
     * The posts
     */
    public Integer getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     * The posts
     */
    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    /**
     *
     * @return
     * The userSubscription
     */
    public Boolean getUserSubscription() {
        return userSubscription;
    }

    /**
     *
     * @param userSubscription
     * The userSubscription
     */
    public void setUserSubscription(Boolean userSubscription) {
        this.userSubscription = userSubscription;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The highlightedPost
     */
    public Object getHighlightedPost() {
        return highlightedPost;
    }

    /**
     *
     * @param highlightedPost
     * The highlightedPost
     */
    public void setHighlightedPost(Object highlightedPost) {
        this.highlightedPost = highlightedPost;
    }

}
