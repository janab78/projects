enum ChessColor {
    WHITE {
        @Override
        public ChessColor getOpposite() {
            return BLACK;
        }
    },
    BLACK {
        @Override
        public ChessColor getOpposite() {
            return WHITE;
        }
    };

    public abstract ChessColor getOpposite();
}