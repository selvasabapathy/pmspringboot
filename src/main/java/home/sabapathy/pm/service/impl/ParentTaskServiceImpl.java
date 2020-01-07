package home.sabapathy.pm.service.impl;

import home.sabapathy.pm.api.exception.ParentTaskException;
import home.sabapathy.pm.api.exception.ProjectException;
import home.sabapathy.pm.service.api.ParentTaskService;
import home.sabapathy.pm.service.api.ProjectService;
import home.sabapathy.pm.service.entity.ParentTask;
import home.sabapathy.pm.service.entity.Project;
import home.sabapathy.pm.service.repository.ParentTaskRepository;
import home.sabapathy.pm.service.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j

@Service
@Transactional
public class ParentTaskServiceImpl implements ParentTaskService {

    @Autowired
    ParentTaskRepository parentTaskRepository;

    @Override
    public ParentTask add(ParentTask parentTask) {
        log.debug("Adding a ParentTask... {}", parentTask);
        return parentTaskRepository.save(parentTask);
    }

    @Override
    public ParentTask edit(ParentTask parentTask) {
        log.debug("Saving the edited ParentTask... {}", parentTask);
        return parentTaskRepository.save(parentTask);    }

    @Override
    public void delete(long parentTaskId) {
        log.debug("Deleting the ParentTask with parentTaskId: {}", parentTaskId);
        parentTaskRepository.deleteById(parentTaskId);
    }

    @Override
    public ParentTask get(long parentTaskId) {
        log.debug("ParentTask not found for parentTaskId {}", parentTaskId);
        return parentTaskRepository.findById(parentTaskId).orElseThrow(() -> new ParentTaskException(String.format("ParentTask not found for parentTaskId \"%s\"", parentTaskId)));
    }

    @Override
    public List<ParentTask> getAll() {
        log.debug("Get all ParentTask..");
        return parentTaskRepository.findAll();
    }


}
