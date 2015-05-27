public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int []> skyline = new ArrayList<int []>();
        List<Event> events = new ArrayList<Event>();
        TreeSet<Building> activeBuilding = new TreeSet<Building>();
        activeBuilding.add(new Building(0,0,0));
        for (int i=0; i < buildings.length; i++) {
            int l = buildings[i][0];
            int r = buildings[i][1];
            int h = buildings[i][2];
            events.add(new Event(l,h,State.enter,new Building(l,r,h)));
            events.add(new Event(r,h,State.leave,new Building(l,r,h)));
        }
        Collections.sort(events);
        int curHight = 0;
        for (int i=0; i < events.size(); i++) {
            int x = events.get(i).x;
            int h = events.get(i).y;
            State s = events.get(i).s;
            Building building = events.get(i).building;
            if (s == State.enter) {
                if (h > curHight) {
                    skyline.add(new int[]{x,h});
                    curHight = h;
                }
                activeBuilding.add(building);

            } else {
                activeBuilding.remove(building);
                int newHeight=0;
                curHight = activeBuilding.first().h;
                if (skyline.get(skyline.size()-1)[1] != curHight)
                    skyline.add(new int[]{x,curHight});
            }
        }

        return skyline;
    }

    class Building implements Comparable {
        public int x;
        public int y;
        public int h;
        public Building(int x, int y, int h) {
            this.x=x;
            this.y=y;
            this.h=h;
        }
        @Override
        public int compareTo(Object o) {
            Building b = (Building) o;
            if (h != b.h)
                return Integer.compare(b.h, h);
            if (x != b.x)
                return Integer.compare(x, b.x);
            else
                return Integer.compare(y,b.y);
        }
    }
    class Event implements Comparable {
        public int x;
        public int y;
        public State s;
        Building building;
        public Event(int x, int y, State s, Building building) {
            this.x=x;
            this.y=y;
            this.s=s;
            this.building=building;
        }

        @Override
        public int compareTo(Object o) {
            Event e = (Event) o;
            if (x != (e.x))
                return Integer.compare(x, e.x);

            if (s==State.enter && e.s==State.enter) {
                return Integer.compare(e.building.h,building.h);
            } else if (s==State.enter && e.s==State.leave) {
                return -1;
            } else if (s==State.leave && e.s==State.enter) {
                return 1;
            } else {
                return Integer.compare(building.h,e.building.h);
            }

        }
    }
    enum State {
        enter,
        leave
    };
}
