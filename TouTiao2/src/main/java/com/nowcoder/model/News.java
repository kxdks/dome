package com.nowcoder.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/2.
 */
public class News {
    private int id;
    private String title;
    private String link;//超链接
    private String image;
    private int likeCount;//赞踩数量
    private int commentCount;//评论数量
    private int userId;//发布者id
    private Date createdDate;//发布时间

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getLink() {return link;}

    public void setLink(String link) {this.link = link;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public int getLikeCount() {return likeCount;}

    public void setLikeCount(int likCount) {this.likeCount = likCount;}

    public int getCommentCount() {return commentCount;}

    public void setCommentCount(int commentCount) {this.commentCount = commentCount;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public Date getCreatedDate() {return createdDate;}

    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}
}
