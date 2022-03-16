package be.fedei91.todoapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "todoitems")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String itemDescription;
    private Boolean itemDone;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public TodoItem(String itemDescription, Boolean itemDone) {
        this.itemDescription = itemDescription;
        this.itemDone = itemDone;
    }

    protected TodoItem() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Boolean getItemDone() {
        return itemDone;
    }

    public void setItemDone(Boolean itemDone) {
        this.itemDone = itemDone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
