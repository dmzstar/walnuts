package com.dmzcoding.walnuts.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.*

@Entity
@Table(name="sec_user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @Column(unique = false,nullable = false)
        var username:String,
        var password:String,
        var email:String,
        @Column(nullable = false)
        var remark: String,
        @Temporal(TemporalType.DATE)
        var dateCreated:Date
)

@Repository
interface UserRepository : JpaRepository<User,Long>

@Entity
@Table(name="sec_role")
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @Column(unique = false,nullable = false)
        var name:String,
        var remark: String,
        @Temporal(TemporalType.DATE)
        var dateCreated:Date,
        @Temporal(TemporalType.DATE)
        var dateUpdated:Date
)

@Repository
interface RoleRepository : JpaRepository<Role,Long>


@Entity
@Table(name="sec_group")
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @Column(unique = true,nullable = false)
        var name:String,
        var remark: String
)


@Repository
interface GroupRepository : JpaRepository<Group,Long>