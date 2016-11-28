package radishevsky.menu;

/**
 * interface UserAction
 *
 * @author vladradishevsky
 * @since 28.11.2016
 * @version 1.0
 **/
public interface UserAction {
    /**
     * Ключ, по которому у пользователя запрашивается, какое действие нужно выполнить
     **/
    int key();

    /**
     * Метод, который выполняет основное действие (добавление/редактирование/удаление/поиск/вывод)
     **/
    void execute(Input input, Tracker tracker);

    /**
     * Сообщаем пользователю, что делает данный метод
     **/
    String info();

}
