%%
clear;
clc;
close all;
b1 = 4;
a1 = [1 2 17];
ps = roots(a1)
figure;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
%%
omega = [-10:0.5:10];
H1 = freqs(b1,a1,omega);
plot(omega,abs(H1));xlabel('w');ylabel('|H1(jw)|');title('|H1(jw)|');
grid;
%%
clc;
close all;
sigma = -1+(1/8)*(1:32);
[sigmagrid, omegagrid]=meshgrid(sigma,omega);
sgrid = sigmagrid + 1i*omegagrid;
H1 = polyval(b1,sgrid)./polyval(a1,sgrid);
mesh(sigma,omega,abs(H1));
%%
view([-80 30]);
%%
view([0 30]);
%%
hold on;
plot3(zeros(1,41),omega,abs(H1(:,8))+0.05,'c');
hold off;
%%
b2 = 4;
a2 = [1 1 16.25];
ps = roots(a2)
figure;
plot(real(ps),imag(ps),'x');
axis([-6 6 -6 6]);
grid;
H2 = freqs(b2,a2,omega);
plot(omega,abs(H2));xlabel('w');ylabel('|H2(jw)|');title('|H2(jw)|');
grid;