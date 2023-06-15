import HomeworkOOP5.models.TableModel;
import HomeworkOOP5.presenters.BookingPresenter;
import HomeworkOOP5.presenters.Model;
import HomeworkOOP5.views.BookingView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.showTables();

        // Клиент нажимает на кнопку "Зарезервировать", возбуждается событие,
        // вызывается метод reservationTable()

        bookingView.reservationTable(new Date(), 102, "Сергей");
        bookingView.reservationTable(new Date(), 105, "Игорь");


        bookingView.changeReservationTable(9001, new Date(), 103, "Дмитрий");
        bookingView.changeReservationTable(9006, new Date(), 103, "Дмитрий");


    }

}
