//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\hacke\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

public class aad extends zs
{
    private rb a;
    private int f;
    
    public aad(final rb rb, final rb a) {
        this.a = a;
        this.f = a.a() / 9;
        a.f();
        final int n = (this.f - 4) * 18;
        for (int i = 0; i < this.f; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.a(new aay(a, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }
        for (int k = 0; k < 3; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.a(new aay(rb, l + k * 9 + 9, 8 + l * 18, 103 + k * 18 + n));
            }
        }
        for (int n2 = 0; n2 < 9; ++n2) {
            this.a(new aay(rb, n2, 8 + n2 * 18, 161 + n));
        }
    }
    
    @Override
    public boolean a(final yz yz) {
        return this.a.a(yz);
    }
    
    @Override
    public add b(final yz yz, final int n) {
        add m = null;
        final aay aay = this.c.get(n);
        if (aay != null && aay.e()) {
            final add d = aay.d();
            m = d.m();
            if (n < this.f * 9) {
                if (!this.a(d, this.f * 9, this.c.size(), true)) {
                    return null;
                }
            }
            else if (!this.a(d, 0, this.f * 9, false)) {
                return null;
            }
            if (d.b == 0) {
                aay.c(null);
            }
            else {
                aay.f();
            }
        }
        return m;
    }
    
    @Override
    public void b(final yz yz) {
        super.b(yz);
        this.a.l_();
    }
    
    public rb e() {
        return this.a;
    }
}
