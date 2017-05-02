/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.ITasksService;
import org.muhia.app.psi.orm.model.TasksList;
import org.muhia.app.psi.orm.repo.TasksListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class TasksService implements ITasksService {

    @Autowired
    private TasksListRepository tasksListRepository;

    @Override
    public Optional<Collection<TasksList>> findTaskListByStatus(int status) {
        return tasksListRepository.findTasksListByTaskStatus(status);
    }

}
