//テーブルのカラムを追加
//クエリの設定　セッター・ゲッターの追加
//id
//report_date
//employee_id
//title
//content
//created_at
//updated_at

//いいね 数を追加
// like_count

package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Table(name = "reports")
@NamedQueries({
    @NamedQuery(
        name = "getAllReports",
        query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
    ),
    @NamedQuery(
        name = "getReportsCount",
        query = "SELECT COUNT(r) FROM Report AS r"
    ),
    @NamedQuery(
            name = "getMyAllReports",
            query = "SELECT r FROM Report AS r WHERE r.employee = :employee ORDER BY r.id DESC"
    ),
    @NamedQuery(
            name = "getMyReportsCount",
            query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :employee"
    )
})
@Entity
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//リソース内での連番
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)//日報を登録した社員の社員番号
    private Employee employee;

    @Column(name = "report_date", nullable = false)//いつの日報かを示す日付
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)//日報のタイトル
    private String title;

    @Lob
    @Column(name = "content", nullable = false)//日報の内容
    private String content;

    @Column(name = "created_at", nullable = false)//登録日時
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)//更新日時
    private Timestamp updated_at;

 // いいね数のプロパティを追加
    @Column(name = "like_count", nullable = false)
    private Integer like_count;

 // いいね数のゲッターセッターを追加
    public Integer getLike_count() {
        return like_count;
    }
    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }
    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}