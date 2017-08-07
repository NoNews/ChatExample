# Пример работы чата.


### Сценарий экрана ChatRoomsActivity:

* Загружается список чатов из сети (если нет интернета — ошибка)
* При успешной загрузке, обновляем загруженные чаты  рандомно, раз в 3 секунды:
Изменение статуса(прочитано или нет), изменение баджей, изменение последнего сообщения
* Состояние баджей: Не показываются (0), Показываются: 1-9, 10-99, 99+
* Последнее сообщение отображается наверху


### Сценарий экрана ChatActivity:

* Стартует updater, на 60 секунд. Каждую секунду отрабатывают события, эмулирующие работу сокета: Приходит новое сообщение, появляется информация о том, если собеседник печатает
* После истечения 60 секунд, меняется статус с "онлайн" на "был в сети в @lastSeenDate, чат засыпает на 20 секунд
* Повтор логики по истечении delay
* Можно отправить сообщение собеседнику (сделано с валидацией)


### Используемые библиотеки

1. Moxy
2. Retrofit2
3. Dagger2
4. RxJava2
5. NoValid
6.