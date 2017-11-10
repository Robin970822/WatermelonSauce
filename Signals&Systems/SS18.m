clear;

x1 = sym('cos(pi*t/5)');
x2 = sym('sin(pi*t/5)');
x3 = sym('exp(i*2*pi*t/3)+exp(i*pi*t)');

x3re = compose('real(x3)',x3);
x3im = compose('imag(x3)',x3);

figure;
ezplot(x1,[-10:0.5:10]);xlabel('t');ylabel('x1(t)');grid on;
figure;
ezplot(x2,[-10:0.5:10]);xlabel('t');ylabel('x2(t)');grid on;
figure;
ezplot(x3re,[-6:0.5:6]);xlabel('t');ylabel('Re(x3(t))');grid on;
figure;
ezplot(x3im,[-6:0.5:6]);xlabel('t');ylabel('Im(x3(t))');grid on;