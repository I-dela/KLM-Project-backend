//package Klm1.KLMLineMaintenanceServer.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "UserRequest")
//public class UserRequest {
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @NotNull
//    private User user;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "request_id")
//    @NotNull
//    private Request request;
//
//    @Column(name = "acceptedBy")
//    private int acceptedBy;
//
//    @Column(name = "closedBy")
//    private int closedBy;
//
//
//    public UserRequest() {
//    }
//
//    public UserRequest(@NotNull User user, @NotNull Request request, int acceptedBy, int closedBy) {
//        this.user = user;
//        this.request = request;
//        this.acceptedBy = acceptedBy;
//        this.closedBy = closedBy;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Request getRequest() {
//        return request;
//    }
//
//    public void setRequest(Request request) {
//        this.request = request;
//    }
//
//    public int getAcceptedBy() {
//        return acceptedBy;
//    }
//
//    public void setAcceptedBy(int acceptedBy) {
//        this.acceptedBy = acceptedBy;
//    }
//
//    public int getClosedBy() {
//        return closedBy;
//    }
//
//    public void setClosedBy(int closedBy) {
//        this.closedBy = closedBy;
//    }
//}
