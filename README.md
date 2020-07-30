# Little

This is a small programming language compiling to LC3 assembly & LC3 machine code.

Currently doesn't have a main executable.

Building:

`mvn install`

Examples:
```
def K;
def L;
K <- -5;
L <- 'C';
loop (K) {
    K <- K + 1;
    print L;
    print '\n';
};
```

```
def hello[3];
hello[0] <- 'H';
hello[1] <- 'i';
hello[2] <- '\n';
print hello;
```