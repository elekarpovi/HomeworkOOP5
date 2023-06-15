package presenters;

import HomeworkOOP5.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model tableModel;
    private final View bookingView;
    public BookingPresenter(Model tableModel, View bookingView){
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }

    private Collection <Table> loadTables(){
        return tableModel.loadTables();
    }

    public void showTables(){
        bookingView.showTables(loadTables());
    }

    public void printReservationTableResult(int reservationId){
        bookingView.printReservationTableResult(reservationId);
    }

    public void printReservationTableError(String errorMessage){
        bookingView.printReservationTableError(errorMessage);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try
        {
            int reservationId = tableModel.reservationTable(orderDate, tableNo, name);
            printReservationTableResult(reservationId);
        }
        catch (RuntimeException e){
            printReservationTableError(e.getMessage());
        }

    }

    @Override
    public void changeReservationTable(int oldReservationNo, Date orderDate, int tableNo, String name) {
        try
        {
            int changeReservationId = tableModel.changeReservationTable(oldReservationNo, new Date(), tableNo, name);
            printChangeReservationTableResult(changeReservationId);
        }
        catch (RuntimeException e){
            printChangeReservationTableError(e.getMessage());
        }

    }

    public void printChangeReservationTableResult(int reservationId) {
        bookingView.printChangeReservationTableResult(reservationId);
    }

    public void printChangeReservationTableError(String errorMessage) {
        bookingView.printChangeReservationTableError(errorMessage);
    }

}
