/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import java.util.Collection;
import java.util.Optional;
import org.muhia.app.psi.orm.model.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface TasksListRepository extends JpaRepository<TasksList, Long> {

    Optional<Collection<TasksList>> findTasksListByTaskStatus(int taskStatus);

}
