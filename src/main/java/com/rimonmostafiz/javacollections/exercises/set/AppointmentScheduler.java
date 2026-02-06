package com.rimonmostafiz.javacollections.exercises.set;

// Implement the  AppointmentScheduler using a NavigableSet internally

import com.sun.source.tree.Tree;

import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class AppointmentScheduler {

    NavigableSet<LocalDateTime> navigableSet;

    public AppointmentScheduler() {
        this.navigableSet = new TreeSet<>();
    }

    public void addAppointment(LocalDateTime datetime) {
        this.navigableSet.add(datetime);
    }

    public LocalDateTime getNextAvailableSlot(LocalDateTime datetime) {
        return this.navigableSet.ceiling(datetime);
    }

    public LocalDateTime removeFirstAppointment() {
        return this.navigableSet.removeFirst();
    }

    public LocalDateTime removeLastAppointment() {
        return this.navigableSet.removeLast();
    }

    public NavigableSet<LocalDateTime> getAppointmentsAfter(LocalDateTime datetime) {
        LocalDateTime higher = navigableSet.higher(datetime);
        if (higher != null) {
            return new TreeSet<>(navigableSet.tailSet(higher));
        } else {
            return new TreeSet<>();
        }
    }

    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();

        scheduler.addAppointment(LocalDateTime.of(2023, 3, 4, 10, 0));
        scheduler.addAppointment(LocalDateTime.of(2023, 3, 4, 11, 0));
        scheduler.addAppointment(LocalDateTime.of(2023, 3, 4, 12, 0));
        scheduler.addAppointment(LocalDateTime.of(2023, 3, 4, 13, 0));

        LocalDateTime datetime1 = LocalDateTime.of(2023, 3, 4, 10, 30);
        LocalDateTime nextSlot1 = scheduler.getNextAvailableSlot(datetime1);
        System.out.println("Next available slot after " + datetime1 + ": " + nextSlot1);

        LocalDateTime first = scheduler.removeFirstAppointment();
        System.out.println("Removed first appointment: " + first);

        LocalDateTime last = scheduler.removeLastAppointment();
        System.out.println("Removed last appointment: " + last);

        LocalDateTime datetime3 = LocalDateTime.of(2023, 3, 4, 11, 0);
        NavigableSet<LocalDateTime> appointmentsAfter = scheduler.getAppointmentsAfter(datetime3);
        System.out.println("Appointments after " + datetime3 + ": " + appointmentsAfter);
    }
}
