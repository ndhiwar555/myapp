package com.example.spring_app1_demo.repository;

import com.example.spring_app1_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Employee employee) {
        em.persist(employee);
    }

    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> findEmployees() {
        /*return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();*/

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root); // select all

        return em.createQuery(cq).getResultList();
    }

    public List<Employee> findByDepartment(String dept) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.department = :dept", Employee.class)
                .setParameter("dept", dept)
                .getResultList();
    }

    // Criteria API query
    public List<Employee> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        cq.select(root).where(cb.equal(root.get("name"), name));

        return em.createQuery(cq).getResultList();
    }

    public void delete(Employee employee) {
        em.remove(employee);
    }
}
