%%
close all;
clear;
b = [1];
zs = roots(b)

a1 = [1 2*0 1];
a2 = [1 2*1/4 1];
a3 = [1 2*1 1];
a4 = [1 2*2 1];
%%
ps = roots(a1)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
ps = roots(a2)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
ps = roots(a3)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
ps = roots(a4)
figure;
plot(real(zs),imag(zs),'o');
hold on;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
omega = [-5:0.1:5];
H1 = freqs(b,a1,omega);
H2 = freqs(b,a2,omega);
H3 = freqs(b,a3,omega);
H4 = freqs(b,a4,omega);

figure;
plot(omega,abs(H1));xlabel('w');ylabel('|H1(jw)|');title('|H1(jw)|');
grid;
figure;
plot(omega,abs(H2));xlabel('w');ylabel('|H2(jw)|');title('|H2(jw)|');
grid;
figure;
plot(omega,abs(H3));xlabel('w');ylabel('|H3(jw)|');title('|H3(jw)|');
grid;
figure;
plot(omega,abs(H4));xlabel('w');ylabel('|H4(jw)|');title('|H4(jw)|');
grid;