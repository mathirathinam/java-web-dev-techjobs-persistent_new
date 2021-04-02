## Part 1: Test it with SQL

## Part 2: Test it with SQL
select * from employer where location='Bentonville';
## Part 3: Test it with SQL
drop table job_skills;
drop table job;
## Part 4: Test it with SQL
SELECT DISTINCT name, description
FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;