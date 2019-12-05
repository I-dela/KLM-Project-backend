package Klm1.KLMLineMaintenanceServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_request")
@IdClass(UserRequest.UrequestCPK.class)
public class UserRequest  {

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    private User user_id;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "request_id")
    private Request request_id;


    @Column(name = "acceptedBy" , nullable = true)
    private int acceptedBy;

    @Column(name = "closedBy" , nullable = true)
    private int closedBy;

    public UserRequest() {
    }

    public UserRequest(@NotNull User user_id, @NotNull Request request_id, int acceptedBy, int closedBy) {
        this.user_id = user_id;
        this.request_id = request_id;
        this.acceptedBy = acceptedBy;
        this.closedBy = closedBy;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class UrequestCPK implements Serializable{


        private int user_id;


        private String request_id;

        public UrequestCPK() {
        }

        public UrequestCPK(int user_id, String request_id) {
            this.user_id = user_id;
            this.request_id = request_id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UrequestCPK that = (UrequestCPK) o;
            return user_id == that.user_id &&
                    Objects.equals(request_id, that.request_id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user_id, request_id);
        }


    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Request getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Request request_id) {
        this.request_id = request_id;
    }

    public int getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(int acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public int getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(int closedBy) {
        this.closedBy = closedBy;
    }
}







