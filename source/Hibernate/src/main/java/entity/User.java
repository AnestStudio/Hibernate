package entity;

import dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@NamedNativeQueries({
//    @NamedNativeQuery(
//        name="FindAllUsers",
//        query="SELECT * FROM [user]"
//    ),
//    @NamedNativeQuery(
//        name="FindAllUsersByUsernameAndPassword",
//        query="SELECT username, password FROM [user]"
//    )
//})

//@NamedNativeQuery(
//    name="FindAllUser",
//    query="SELECT * FROM [user]"
//)

//@NamedNativeQuery(
//    name="FindAllUsersByUsernameAndPassword",
//    query="SELECT username, password FROM [user]"
//)

//@NamedNativeQuery(
//    name = "FindUserById",
//    query = "SELECT * FROM [User] WHERE user_id = :userId",
//    resultClass = User.class
//)

//@NamedNativeQuery(
//    name="FindUserByUsernameAndPassword",
//    query="SELECT username, password FROM [user]",
//    resultSetMapping = "UserDTOMapping"
//)
//@SqlResultSetMapping(
//    name = "UserDTOMapping",
//    classes = @ConstructorResult(
//        targetClass = UserDTO.class,
//        columns = {
//            @ColumnResult(name="username"),
//            @ColumnResult(name="password")
//        }
//    )
//)

//@NamedNativeQuery(
//    name="FindAllUsersCustom",
//    query="SELECT u.user_id as id, u.username as account, u.password, u.created_at, u.modified_at FROM [user] u",
//    resultSetMapping = "UserCustomMapping"
//)
//@SqlResultSetMapping(
//    name = "UserCustomMapping",
//    entities = @EntityResult(
//        entityClass = User.class,
//        fields = {
//            @FieldResult(name="userId", column="id"),
//            @FieldResult(name="username", column="account"),
//            @FieldResult(name="password", column="password"),
//            @FieldResult(name="createdAt", column="created_at"),
//            @FieldResult(name="modifiedAt", column="modified_at")
//        }
//    )
//)

//@NamedNativeQuery(
//    name = "FindAllUsersWithDetailInfo",
//    query = """
//        SELECT
//            u.user_id, u.username, u.password, u.created_at, u.modified_at,
//            ud.user_detail_id, ud.first_name, ud.last_name, ud.gender, ud.bod, ud.mobile, ud.email
//        FROM [user] u
//        JOIN user_detail ud
//            on u.user_id = ud.user_id
//    """,
//    resultSetMapping = "UserWithDetailInfoMapping"
//)
//@SqlResultSetMapping(
//    name = "UserWithDetailInfoMapping",
//    entities = {
//        @EntityResult(
//            entityClass = User.class,
//            fields = {
//                @FieldResult(name="userId", column="user_id"),
//                @FieldResult(name="username", column="username"),
//                @FieldResult(name="password", column="password"),
//                @FieldResult(name="createdAt", column="created_at"),
//                @FieldResult(name="modifiedAt", column="modified_at")
//            }
//        ),
//        @EntityResult(
//            entityClass = UserDetail.class,
//            fields = {
//                @FieldResult(name="userDetailId", column="user_detail_id"),
//                @FieldResult(name="firstName", column="first_name"),
//                @FieldResult(name="lastName", column="last_name"),
//                @FieldResult(name="gender", column="gender"),
//                @FieldResult(name="bod", column="bod"),
//                @FieldResult(name="mobile", column="mobile"),
//                @FieldResult(name="email", column="email")
//            }
//        )
//    }
//)

//@NamedNativeQuery(
//    name = "FindAllUsersWithFullName",
//    query = """
//        SELECT
//            u.user_id, u.username, u.password, u.created_at, u.modified_at,
//            CONCAT(ud.first_name, ' ', ud.last_name) AS full_name
//        FROM [user] u
//        JOIN user_detail ud
//            on u.user_id = ud.user_id
//    """,
//    resultSetMapping = "UserWithFullNameMapping"
//)
//@SqlResultSetMapping(
//    name = "UserWithFullNameMapping",
//    entities = @EntityResult(
//        entityClass = User.class,
//        fields = {
//            @FieldResult(name="userId", column="user_id"),
//            @FieldResult(name="username", column="username"),
//            @FieldResult(name="password", column="password"),
//            @FieldResult(name="createdAt", column="created_at"),
//            @FieldResult(name="modifiedAt", column="modified_at")
//        }
//    ),
//    columns = @ColumnResult(name = "full_name", type = String.class)
//)
@Getter
@Setter
@Entity
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;
}
