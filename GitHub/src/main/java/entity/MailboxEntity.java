package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mailboxes", schema = "CasinoUsers")
public class MailboxEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "messages")
    private String messages;
    @Basic
    @Column(name = "user_id")
    private int user_id;
    @Basic
    @Column(name = "sender")
    private String sender;

    public void setUserId(int id) { this.user_id = id; }
    public int getUserId() { return this.user_id; }
    public void setId(int id) {this.id = id; }
    public int getId() { return this.id; }
    public void setMessages(String messages) { this.messages = messages; }
    public String getMessages() { return this.messages; }
    public void setSender(String sender) { this.sender = sender; }
    public String getSender() { return this.sender; }
}
