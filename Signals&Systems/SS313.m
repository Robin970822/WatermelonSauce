%%
clear;
H=sym('1/(1+0.1*i*w)');

Hh=compose('abs(H)',H);
Ha=compose('angle(H)',H);

figure;
subplot(2,1,1);
ezplot(Hh,[-10:10]);xlabel('w');ylabel('|H|');
subplot(2,1,2);
ezplot(Ha,[-10:10]);xlabel('w');ylabel('angle(H)');
%%
cnt = 0;
for i=1:10000
    for j=1:10000
        for k=1:10000
            for n=1:10000
                cnt=cnt+1;
            end
        end
    end
end