package thsCrack;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class erb extends InputStream implements DataInput {
    protected volatile InputStream a;

    public erb(InputStream arg1) {
        this.a = arg1;
    }

    public final long a() throws IOException {
        byte[] v2 = new byte[4];
        int v0;
        int v3;
        for(v0 = 0; v0 < 4; v0 += v3) {
            v3 = this.a.read(v2, v0, 4 - v0);
            if(v3 == -1) {
                throw new EOFException();
            }
        }

        return ((long)(v2[0] & 0xFF)) + ((((long)(v2[2] & 0xFF)) + (((long)(v2[3] & 0xFF)) << 8) << 8) + ((long)(v2[1] & 0xFF)) << 8);
    }

    public final String a(int arg4) throws IOException {
        if(arg4 <= 0) {
            return null;
        }

        char[] v1 = new char[arg4];
        int v0;
        for(v0 = 0; v0 < arg4; ++v0) {
            v1[v0] = this.readChar();
        }

        return new String(v1);
    }

    @Override
    public final int available() throws IOException {
        return this.a.available();
    }

    @Override
    public void close() throws IOException {
        this.a.close();
    }

    @Override
    public void mark(int arg2) {
        synchronized(this) {
            this.a.mark(arg2);
        }
    }

    @Override
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override
    public final int read() throws IOException {
        return this.a.read();
    }

    @Override
    public final boolean readBoolean() throws IOException {
        int v0 = this.a.read();
        if(v0 < 0) {
            throw new EOFException();
        }

        return v0 != 0;
    }

    @Override
    public final byte readByte() throws IOException {
        int v0 = this.a.read();
        if(v0 < 0) {
            throw new EOFException();
        }

        return (byte)v0;
    }

    @Override
    public final char readChar() throws IOException {
        int v0 = this.a.read();
        int v1 = this.a.read();
        if((v0 | v1) < 0) {
            throw new EOFException();
        }

        return (char)(v0 + (v1 << 8));
    }

    @Override
    public final double readDouble() throws IOException {
        byte[] v1 = new byte[8];
        int v0;
        int v2;
        for(v0 = 0; v0 < 8; v0 += v2) {
            v2 = this.a.read(v1, v0, 8 - v0);
            if(v2 == -1) {
                throw new EOFException();
            }
        }

        return 0.0;
    }

    @Override
    public final float readFloat() throws IOException {
        this.readInt();
        return 0.0f;
    }

    @Override
    public final void readFully(byte[] arg3) throws IOException {
        this.readFully(arg3, 0, arg3.length);
    }

    @Override
    public final void readFully(byte[] arg5, int arg6, int arg7) throws IOException {
        if(arg7 < 0) {
            throw new IndexOutOfBoundsException();
        }

        int v0;
        int v1;
        for(v0 = 0; v0 < arg7; v0 += v1) {
            v1 = this.a.read(arg5, arg6 + v0, arg7 - v0);
            if(v1 < 0) {
                throw new EOFException();
            }
        }
    }

    @Override
    public final int readInt() throws IOException {
        byte[] v2 = new byte[4];
        int v0;
        int v3;
        for(v0 = 0; v0 < 4; v0 += v3) {
            v3 = this.a.read(v2, v0, 4 - v0);
            if(v3 == -1) {
                throw new EOFException();
            }
        }

        return (v2[0] & 0xFF) + ((v2[1] & 0xFF) + (((v2[3] & 0xFF) << 8) + (v2[2] & 0xFF) << 8) << 8);
    }

    @Override
    public final String readLine() throws IOException {
        return null;
    }

    @Override
    public long readLong() throws IOException {
        int v0 = this.readInt();
        int v1 = this.a.read();
        int v2 = this.a.read();
        int v3 = this.a.read();
        int v4 = this.a.read();
        if((v4 | v3 | v2 | v1) < 0) {
            throw new EOFException();
        }

        return ((long)v1) + (((long)(v2 << 8)) + ((((long)v4) << 24) + (((long)v0) << 0x20) + ((long)(v3 << 16))));
    }

    @Override
    public final short readShort() throws IOException {
        byte[] v2 = new byte[2];
        int v0;
        int v3;
        for(v0 = 0; v0 < 2; v0 += v3) {
            v3 = this.a.read(v2, v0, 2 - v0);
            if(v3 == -1) {
                throw new EOFException();
            }
        }

        return (short)((v2[0] & 0xFF) + ((v2[1] & 0xFF) << 8));
    }

    @Override
    public final String readUTF() throws IOException {
        return this.a(this.readUnsignedShort());
    }

    @Override
    public final int readUnsignedByte() throws IOException {
        int v0 = this.a.read();
        if(v0 < 0) {
            throw new EOFException();
        }

        return v0;
    }

    @Override
    public final int readUnsignedShort() throws IOException {
        int v0 = this.a.read();
        int v1 = this.a.read();
        if((v0 | v1) < 0) {
            throw new EOFException();
        }

        return v0 + (v1 << 8);
    }

    @Override
    public void reset() throws IOException {
        synchronized(this) {
            this.a.reset();
        }
    }

    @Override
    public long skip(long arg4) throws IOException {
        return this.a.skip(arg4);
    }

    @Override
    public final int skipBytes(int arg5) throws IOException {
        int v0;
        int v1;
        for(v0 = 0; v0 < arg5; v0 += v1) {
            v1 = (int)this.a.skip(((long)(arg5 - v0)));
            if(v1 <= 0) {
                return v0;
            }
        }

        return v0;
    }
}

