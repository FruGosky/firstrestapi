package com.example.firstrestapi.job.impl;

import com.example.firstrestapi.job.Job;
import com.example.firstrestapi.job.JobRepository;
import com.example.firstrestapi.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void create(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public boolean update(Long id, Job newJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isEmpty()) return false;

        Job job = jobOptional.get();
        job.setTitle(newJob.getTitle());
        job.setDescription(newJob.getDescription());
        job.setMinSalary(newJob.getMinSalary());
        job.setMaxSalary(newJob.getMaxSalary());
        job.setLocation(newJob.getLocation());
        jobRepository.save(job);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
