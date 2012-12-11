package oss.process.scrum.mapper;

public interface IMapper<X, Y> {
    Y map(X x);
}
