drop table if EXISTS sys_user;
drop table if EXISTS sys_organization;
drop table if EXISTS sys_resource;
drop table if EXISTS sys_role;

create table sys_user (
  id bigint auto_increment,
  organization_id BIGINT,
  username varchar(100),
  password varchar(100),
  salt varchar(100),
  role_ids varchar(100),
  locked BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_user PRIMARY KEY(id)
)CHARSET=utf8 ENGINE=InnoDB;

create UNIQUE index idx_sys_user_username ON sys_user(username);
create INDEX idx_sys_user_organization_id ON sys_user(organization_id);

create table sys_organization(
  id BIGINT AUTO_INCREMENT,
  name VARCHAR(100),
  parent_id BIGINT,
  parent_ids VARCHAR(100),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_organization PRIMARY KEY(id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE index idx_organization_parent_id ON sys_organization(parent_id);
CREATE index idx_organization_parent_ids ON sys_organization(parent_ids);

CREATE table sys_resource(
  id BIGINT AUTO_INCREMENT,
  name VARCHAR(100),
  type VARCHAR(50),
  url VARCHAR(200),
  parent_id BIGINT,
  parent_ids VARCHAR(100),
  permission VARCHAR(100),
  available BOOL DEFAULT FALSE ,
  CONSTRAINT pk_sys_resource PRIMARY KEY(id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE index idx_sys_resource_parent_id ON sys_resource(parent_id);
CREATE index idx_sys_resource_parent_ids ON sys_resource(parent_ids);

CREATE table sys_role(
  id BIGINT AUTO_INCREMENT,
  role VARCHAR(100),
  description VARCHAR(100),
  resource_ids VARCHAR(100),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_role PRIMARY KEY(id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE index idx_sys_role_resource_ids ON sys_role(resource_ids);