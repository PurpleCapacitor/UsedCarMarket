package ucm.specifications;

import org.checkerframework.checker.units.qual.A;
import org.springframework.data.jpa.domain.Specification;
import ucm.models.Ad;
import ucm.models.Extras;

import javax.persistence.criteria.*;

public class AdSpecification {

    public static Specification<Ad> withCruiseControl(boolean cc) {
        if (!cc) {
            return null;
        } else {
            return new Specification<Ad>() {
                @Override
                public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.equal(root.join("extras").get("cruiseControl"), true);
                }
            };

        }
    }

    public static Specification<Ad> withElectricalMirrors(boolean electricalMirrors) {
        if (!electricalMirrors)
            return null;
        else return new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.join("extras").get("electricalMirrors"), true);
            }
        };
    }

    public static Specification<Ad> withElectricalSeats(boolean electricalSeats) {
        if (!electricalSeats)
            return null;
        else return new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.join("extras").get("electricalSeats"), true);
            }
        };
    }

    public static Specification<Ad> withElectricalWindows(boolean electricalWindows) {
        if (!electricalWindows)
            return null;
        else return new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.join("extras").get("electricalWindows"), true);
            }
        };
    }

    public static Specification<Ad> withMultifunctionalSteeringWheel(boolean multifunctionalSteeringWheel) {
        if (!multifunctionalSteeringWheel)
            return null;
        else return new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.join("extras").get("multifunctionalSteeringWheel"), true);
            }
        };
    }

    public static Specification<Ad> withBluetooth(boolean bluetooth) {
        if (!bluetooth)
            return null;
        else return new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.join("extras").get("bluetooth"), true);
            }
        };
    }

    public static Specification<Ad> withLedHeadlights(boolean lh) {
        if (!lh)
            return null;
        else
            return new Specification<Ad>() {
                @Override
                public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.equal(root.join("extras").get("ledHeadlights"), true);
                }
            };

    }

    public static Specification<Ad> withHeatedSeats(boolean heatedSeats) {
        if (!heatedSeats)
            return null;
        else return new Specification<Ad>() {
            @Override
            public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.join("extras").get("heatedSeats"), true);
            }
        };
    }
}
