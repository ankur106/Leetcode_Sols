class MyCalendarTwo {

    private TreeMap<Integer, Integer> bookingCount;
    private int maxOverlappedBooking;

    public MyCalendarTwo() {
        bookingCount = new TreeMap<>();
        maxOverlappedBooking = 2;
    }

    public boolean book(int start, int end) {
        bookingCount.put(start, bookingCount.getOrDefault(start, 0) + 1);
        bookingCount.put(end, bookingCount.getOrDefault(end, 0) - 1);

        int overlappedBooking = 0;

        for (Map.Entry<Integer, Integer> entry : bookingCount.entrySet()) {
            overlappedBooking += entry.getValue();

            if (overlappedBooking > maxOverlappedBooking) {
                bookingCount.put(start, bookingCount.get(start) - 1);
                bookingCount.put(end, bookingCount.get(end) + 1);

                if (bookingCount.get(start) == 0) {
                    bookingCount.remove(start);
                }

                return false;
            }
        }

        return true;
    }
}