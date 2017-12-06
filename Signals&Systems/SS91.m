%%
clear;
b = [1 5];
a = [1 2 3];
zs = roots(b)
ps = roots(a)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
clear;
b = [2 5 12];
a = [1 2 10];
zs = roots(b)
ps = roots(a)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
clear;
b = [2 5 12];
a = [1 4 14 20];
zs = roots(b)
ps = roots(a)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;

%%
clear;
b = [1 2 5];
a = [1 -3];
zs = roots(b)
ps = roots(a)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;