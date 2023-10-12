# Thực hành WWW Week5
# Yêu cầu
1. Tạo các enities sao cho khi thực thi sẽ tạo ra các bảng như hình
   
3. Viết các repositories interface
4. Viết các lớp services
5. Tạo các trang web cho phép công ty đăng tin tuyển người với các skill mong muốn
6. Các ứng viên khi log vào sẽ được gợi ý các công việc có skill phù hợp với mình
7. Giúp các công ty tìm các ứng viên có skill phù hợp rồi gửi mail mời.
8. Đề xuất một số skill mà ứng viên chưa có để học.

```markdown

## General Information

- Host: 127.0.0.1
- Server version: 11.1.2-MariaDB - mariadb.org binary distribution
- Server OS: Win64
- HeidiSQL Version: 12.3.0.6589

## Database Creation

```sql
CREATE DATABASE IF NOT EXISTS `work`
USE `work`;

 `address`

- `country` INT(11) NOT NULL
- `add_id` BIGINT(20) NOT NULL AUTO_INCREMENT
- `candidate_id` BIGINT(20) DEFAULT NULL
- `company_comp_id` BIGINT(20) DEFAULT NULL
- `city` VARCHAR(50) DEFAULT NULL
- `number` VARCHAR(20) DEFAULT NULL
- `phone` VARCHAR(7) DEFAULT NULL
- `street` VARCHAR(150) DEFAULT NULL
 `candidate`

- `dob` DATE DEFAULT NULL
- `address` BIGINT(20) DEFAULT NULL
- `id` BIGINT(20) NOT NULL AUTO_INCREMENT
- `email` VARCHAR(255) DEFAULT NULL
- `full_name` VARCHAR(255) DEFAULT NULL
- `phone` VARCHAR(15) DEFAULT NULL

 `candidate_skill`

- `skill_level` TINYINT(4) DEFAULT NULL CHECK (`skill_level` BETWEEN 0 AND 3)
- `can_id` BIGINT(20) NOT NULL
- `skill_id` BIGINT(20) NOT NULL
- `more_infos` VARCHAR(255) DEFAULT NULL

 `company`

- `address` BIGINT(20) DEFAULT NULL
- `comp_id` BIGINT(20) NOT NULL AUTO_INCREMENT
- `about` VARCHAR(2000) DEFAULT NULL
- `comp_name` VARCHAR(2000) DEFAULT NULL
- `email` VARCHAR(255) DEFAULT NULL
- `phone` VARCHAR(2000) DEFAULT NULL
- `weburl` VARCHAR(2000) DEFAULT NULL

 `experience`

- `from_date` DATE DEFAULT NULL
- `to_date` DATE DEFAULT NULL
- `can_id` BIGINT(20) DEFAULT NULL
- `exp_id` BIGINT(20) NOT NULL AUTO_INCREMENT
- `company` VARCHAR(120) DEFAULT NULL
- `role` VARCHAR(100) DEFAULT NULL
- `work_desc` VARCHAR(400) DEFAULT NULL

 `job`

- `id` BIGINT(20) NOT NULL AUTO_INCREMENT
- `job_id` BIGINT(20) DEFAULT NULL
- `job_desc` VARCHAR(2000) DEFAULT NULL
- `job_name` VARCHAR(2000) DEFAULT NULL


 `job_skill`

- `skill_level` TINYINT(4) DEFAULT NULL CHECK (`skill_level` BETWEEN 0 AND 3)
- `job_id` BIGINT(20) NOT NULL
- `job_skills_skill_id` BIGINT(20) DEFAULT NULL
- `skill_id` BIGINT(20) NOT NULL
- `more_infos` VARCHAR(255) DEFAULT NULL

 `skill`

- `skill_type` TINYINT(4) DEFAULT NULL CHECK (`skill_type` BETWEEN 0 AND 2)
- `skill_id` BIGINT(20) NOT NULL AUTO_INCREMENT
- `skill_description` VARCHAR(300) DEFAULT NULL
- `skill_name` VARCHAR(150) DEFAULT NULL


```

```sql
