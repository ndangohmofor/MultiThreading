package thread.race.condition.atomic.minmax;

import java.util.Comparator;
import java.util.List;

public class Main {

    public class MinMaxMetrics {
        private List<Long> sample;

        public MinMaxMetrics(List<Long> sample) {
            this.sample = sample;
            Long.M
        }

        public void addSample(long newSample) {
            this.sample.add(newSample);
        }

        public long getMin() {
            return this.sample.stream().min(Comparator.naturalOrder()).get();
        }

        public long getMax() {
            return this.sample.stream().max(Comparator.naturalOrder()).get();
        }
    }
}
