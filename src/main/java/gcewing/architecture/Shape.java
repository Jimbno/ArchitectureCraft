// ------------------------------------------------------------------------------
//
// ArchitectureCraft - Shape enum
//
// ------------------------------------------------------------------------------

package gcewing.architecture;

import static gcewing.architecture.BaseBlockUtils.*;
import static gcewing.architecture.BaseUtils.*;
import static gcewing.architecture.Profile.*;
import static gcewing.architecture.Profile.Generic.*;
import static gcewing.architecture.ShapeFlags.*;
import static gcewing.architecture.ShapeKind.*;
import static gcewing.architecture.ShapeSymmetry.*;
import static gcewing.architecture.WindowShapeKinds.*;
import static java.lang.Math.*;
import static net.minecraft.util.EnumFacing.*;

import java.util.*;

import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;

public enum Shape {

    RoofTile(0, "Roof Tile", Roof, Bilateral, 1, 2, 0xcf),
    RoofOuterCorner(1, "Roof Outer Corner", Roof, Unilateral, 1, 3, 0x4f),
    RoofInnerCorner(2, "Roof Inner Corner", Roof, Unilateral, 2, 3, 0xdf),
    RoofRidge(3, "Gabled Roof Ridge", Roof, Bilateral, 1, 4, 0x0f),
    RoofSmartRidge(4, "Hip Roof Ridge", Roof, Quadrilateral, 1, 2, 0x0f),
    RoofValley(5, "Gabled Roof Valley", Roof, Bilateral, 1, 2, 0xff),
    RoofSmartValley(6, "Hip Roof Valley", Roof, Quadrilateral, 1, 1, 0xff),

    RoofOverhang(7, "Roof Overhang", Model("roof_overhang"), Bilateral, 1, 2, 0xcf),
    RoofOverhangOuterCorner(8, "Roof Overhang Outer Corner", Model("roof_overhang_outer_corner"), Unilateral, 1, 3,
            0x4f),
    RoofOverhangInnerCorner(9, "Roof Overhang Inner Corner", Model("roof_overhang_inner_corner"), Unilateral, 2, 3,
            0xdf),

    Cylinder(10, "Cylinder", Model("cylinder_full_r8h16"), Quadrilateral, 1, 1, 0xff),
    CylinderHalf(11, "Half Cylinder", Model("cylinder_half_r8h16"), Bilateral, 1, 1, 0xcc),
    CylinderQuarter(12, "Quarter Cylinder", Model("cylinder_quarter_r8h16"), Unilateral, 1, 1, 0x44),
    CylinderLargeQuarter(13, "Round Outer Corner", Model("cylinder_quarter_r16h16"), Unilateral, 1, 1, 0xff),
    AnticylinderLargeQuarter(14, "Round Inner Corner", Model("round_inner_corner"), Unilateral, 1, 2, 0xdd),
    Pillar(15, "Round Pillar", Model("cylinder_r6h16"), Quadrilateral, 1, 1, 0x106),
    Post(16, "Round Post", Model("cylinder_r4h16"), Quadrilateral, 1, 4, 0x104),
    Pole(17, "Round Pole", Model("cylinder_r2h16"), Quadrilateral, 1, 16, 0x102),

    BevelledOuterCorner(18, "Bevelled Outer Corner", Model("bevelled_outer_corner"), Unilateral, 1, 3, 0x4f),
    BevelledInnerCorner(19, "Bevelled Inner Corner", Model("bevelled_inner_corner"), Unilateral, 1, 1, 0xdf),

    PillarBase(20, "Round Pillar Base", Model("pillar_base"), Quadrilateral, 1, 1, 0xff),
    DoricCapital(21, "Doric Capital", Model("doric_capital"), Quadrilateral, 1, 1, 0xff),
    IonicCapital(22, "Ionic capital", Model("ionic_capital"), Bilateral, 1, 1, 0xff),
    CorinthianCapital(23, "Corinthian capital", Model("corinthian_capital"), Quadrilateral, 1, 1, 0xff),
    DoricTriglyph(24, "Triglyph", Model("doric_triglyph", lrStraight), Bilateral, 1, 1, 0xff),
    DoricTriglyphCorner(25, "Triglyph Corner", Model("doric_triglyph_corner", lrCorner), Bilateral, 1, 1, 0xff),
    DoricMetope(26, "Metope", Model("doric_metope", lrStraight), Bilateral, 1, 1, 0xff),
    Architrave(27, "Architrave", Model("architrave", lrStraight), Bilateral, 1, 1, 0xff),
    ArchitraveCorner(28, "Architrave Corner", Model("architrave_corner", lrCorner), Unilateral, 1, 1, 0xff),

    WindowFrame(30, "Window Frame", PlainWindow, Bilateral, 1, 4, 0x202),
    WindowCorner(31, "Window Corner", CornerWindow, Unilateral, 1, 2, 0x202),
    WindowMullion(32, "Window Mullion", MullionWindow, Bilateral, 1, 2, 0x202),

    SphereFull(33, "Sphere", Model("sphere_full_r8"), Quadrilateral, 1, 1, 0xff),
    SphereHalf(34, "Hemisphere", Model("sphere_half_r8"), Quadrilateral, 1, 2, 0x0f),
    SphereQuarter(35, "Quarter Sphere", Model("sphere_quarter_r8"), Bilateral, 1, 4, 0x0c),
    SphereEighth(36, "Quarter Hemisphere", Model("sphere_eighth_r8"), Unilateral, 1, 8, 0x04),
    SphereEighthLarge(37, "Round Outer Corner Cap", Model("sphere_eighth_r16"), Unilateral, 1, 1, 0xff),
    SphereEighthLargeRev(38, "Round Inner Corner Cap", Model("sphere_eighth_r16_rev"), Unilateral, 1, 1, 0xdf),

    RoofOverhangGableLH(40, "Gable Overhang LH", Model("roof_overhang_gable_lh"), Bilateral, 1, 4, 0x48),
    RoofOverhangGableRH(41, "Gable Overhang RH", Model("roof_overhang_gable_rh"), Bilateral, 1, 4, 0x84),
    RoofOverhangGableEndLH(42, "Gable Overhang LH End", Model("roof_overhang_gable_end_lh"), Bilateral, 1, 4, 0x48),
    RoofOverhangGableEndRH(43, "Gable Overhang RH End", Model("roof_overhang_gable_end_rh"), Bilateral, 1, 4, 0x48),
    RoofOverhangRidge(44, "Ridge Overhang", Model("roof_overhang_gable_ridge"), Bilateral, 1, 4, 0x0c),
    RoofOverhangValley(45, "Valley Overhang", Model("roof_overhang_gable_valley"), Bilateral, 1, 4, 0xcc),

    CorniceLH(50, "Cornice LH", Model("cornice_lh"), Bilateral, 1, 4, 0x48),
    CorniceRH(51, "Cornice RH", Model("cornice_rh"), Bilateral, 1, 4, 0x84),
    CorniceEndLH(52, "Cornice LH End", Model("cornice_end_lh"), Bilateral, 1, 4, 0x48),
    CorniceEndRH(53, "Cornice RH End", Model("cornice_end_rh"), Bilateral, 1, 4, 0x48),
    CorniceRidge(54, "Cornice Ridge", Model("cornice_ridge"), Bilateral, 1, 4, 0x0c),
    CorniceValley(55, "Cornice Valley", Model("cornice_valley"), Bilateral, 1, 4, 0xcc),
    CorniceBottom(56, "Cornice Bottom", Model("cornice_bottom"), Bilateral, 1, 4, 0x0c),

    CladdingSheet(60, "Cladding", Cladding, null, 1, 1, 0),

    ArchD1(61, "Arch Diameter 1", Model("arch_d1"), Bilateral, 1, 1, 0xff, placeUnderneath),
    ArchD2(62, "Arch Diameter 2", Model("arch_d2"), Bilateral, 1, 2, 0xfc, placeUnderneath),
    ArchD3A(63, "Arch Diameter 3 Part A", Model("arch_d3a"), Bilateral, 1, 2, 0xcc, placeUnderneath),
    ArchD3B(64, "Arch Diameter 3 Part B", Model("arch_d3b"), Bilateral, 1, 1, 0xfc, placeUnderneath),
    ArchD3C(65, "Arch Diameter 3 Part C", Model("arch_d3c"), Bilateral, 1, 1, 0xff, placeUnderneath),
    ArchD4A(66, "Arch Diameter 4 Part A", Model("arch_d4a"), Bilateral, 1, 2, 0xcc, placeUnderneath),
    ArchD4B(67, "Arch Diameter 4 Part B", Model("arch_d4b"), Bilateral, 1, 1, 0xfc, placeUnderneath),
    ArchD4C(68, "Arch Diameter 4 Part C", Model("arch_d4c"), Bilateral, 1, 2, 0x0, placeUnderneath),

    BanisterPlainBottom(70, "Plain Banister Bottom Transition", Banister("balustrade_stair_plain_bottom"), Bilateral, 1,
            10, 0x0, placeOffset),
    BanisterPlain(71, "Plain Banister", Banister("balustrade_stair_plain"), Bilateral, 1, 10, 0x0, placeOffset),
    BanisterPlainTop(72, "Plain Banister Top Transition", Banister("balustrade_stair_plain_top"), Bilateral, 1, 10, 0x0,
            placeOffset),

    BalustradeFancy(73, "Fancy Balustrade", Model("balustrade_fancy"), Bilateral, 1, 5, 0x0),
    BalustradeFancyCorner(74, "Fancy Corner Balustrade", Model("balustrade_fancy_corner"), Unilateral, 1, 2, 0x0),
    BalustradeFancyWithNewel(75, "Fancy Balustrade with Newel", Model("balustrade_fancy_with_newel"), Bilateral, 1, 3,
            0x0),
    BalustradeFancyNewel(76, "Fancy Newel", Model("balustrade_fancy_newel"), Unilateral, 1, 4, 0x0),

    BalustradePlain(77, "Plain Balustrade", Model("balustrade_plain"), Bilateral, 1, 10, 0x0),
    BalustradePlainOuterCorner(78, "Plain Outer Corner Balustrade", Model("balustrade_plain_outer_corner"), Unilateral,
            1, 4, 0x0),
    BalustradePlainWithNewel(79, "Plain Balustrade with Newel", Model("balustrade_plain_with_newel"), Bilateral, 1, 6,
            0x0),

    BanisterPlainEnd(80, "Plain Banister End", Banister("balustrade_stair_plain_end"), Bilateral, 1, 8, 0x0,
            placeOffset),

    BanisterFancyNewelTall(81, "Tall Fancy Newel", Model("balustrade_fancy_newel_tall"), Unilateral, 1, 2, 0x0),

    BalustradePlainInnerCorner(82, "Plain Inner Corner Balustrade", Model("balustrade_plain_inner_corner"), Unilateral,
            1, 8, 0x0),
    BalustradePlainEnd(83, "Plain Balustrade End", Banister("balustrade_plain_end"), Bilateral, 1, 8, 0x0, placeOffset),

    BanisterFancyBottom(84, "Fancy Banister Bottom Transition", Banister("balustrade_stair_fancy_bottom"), Bilateral, 1,
            5, 0x0, placeOffset),
    BanisterFancy(85, "Fancy Banister", Banister("balustrade_stair_fancy"), Bilateral, 1, 5, 0x0, placeOffset),
    BanisterFancyTop(86, "Fancy Banister Top Transition", Banister("balustrade_stair_fancy_top"), Bilateral, 1, 5, 0x0,
            placeOffset),
    BanisterFancyEnd(87, "Fancy Banister End", Banister("balustrade_stair_fancy_end"), Bilateral, 1, 2, 0x0,
            placeOffset),

    BanisterPlainInnerCorner(88, "Plain Banister Inner Corner", Model("balustrade_stair_plain_inner_corner"),
            Unilateral, 1, 6, 0x0),

    Slab(90, "Slab", Model("slab"), Quadrilateral, 1, 2, 0x0),
    Stairs(91, "Stairs", Model("stairs", lrStraight), Bilateral, 3, 4, 0x0),
    StairsOuterCorner(92, "Stairs Outer Corner", Model("stairs_outer_corner", lrCorner), Unilateral, 2, 3, 0x0),
    StairsInnerCorner(93, "Stairs Inner Corner", Model("stairs_inner_corner", rlCorner), Unilateral, 1, 1, 0x0),

    SlopeTileA1(94, "Slope A Start", Roof, Bilateral, 1, 1, 0xcf),
    SlopeTileA2(95, "Slope A End", Roof, Bilateral, 1, 3, 0x0f),
    SlopeTileB1(96, "Slope B Start", Roof, Bilateral, 1, 1, 0xff),
    SlopeTileB2(97, "Slope B Middle", Roof, Bilateral, 1, 2, 0xcf),
    SlopeTileB3(98, "Slope B End", Roof, Bilateral, 1, 3, 0x0f),
    SlopeTileC1(99, "Slope C 1", Roof, Bilateral, 1, 1, 0xff),
    SlopeTileC2(100, "Slope C 2", Roof, Bilateral, 1, 2, 0xcf),
    SlopeTileC3(101, "Slope C 3", Roof, Bilateral, 1, 3, 0x0f),
    SlopeTileC4(102, "Slope C 4", Roof, Bilateral, 1, 4, 0x0f),;

    public int id;
    public String title;
    public ShapeKind kind;
    public ShapeSymmetry symmetry;
    public int materialUsed;
    public int itemsProduced;
    public int occlusionMask;
    public int flags;

    public static Shape[] values = values();

    protected static Map<Integer, Shape> idMap = new HashMap<Integer, Shape>();

    static {
        for (Shape s : values) idMap.put(s.id, s);
    }

    public static Shape forId(int id) {
        Shape shape = idMap.get(id);
        if (shape == null) shape = RoofTile;
        return shape;
    }

    // Shape(int id, String title, ShapeKind kind, ShapeSymmetry sym, int used, int made, int occ) {
    // this(id, title, kind, sym, used, made, occ, null);
    // }
    //
    // Shape(int id, String title, ShapeKind kind, ShapeSymmetry sym, int used, int made, int occ, String model)

    Shape(int id, String title, ShapeKind kind, ShapeSymmetry sym, int used, int made, int occ) {
        this(id, title, kind, sym, used, made, occ, 0);
    }

    Shape(int id, String title, ShapeKind kind, ShapeSymmetry sym, int used, int made, int occ, int flags) {
        this.id = id;
        this.title = title;
        this.kind = kind;
        this.symmetry = sym;
        this.materialUsed = used;
        this.itemsProduced = made;
        this.occlusionMask = occ;
        this.flags = flags;
    }

    // protected void orientOnPlacement(EntityPlayer player, ShapeTE te, ShapeTE nte, EnumFacing face, Vector3 hit) {
    // if (te.shape.kind.orientOnPlacement(player, te, nte, face, hit))
    // return;
    // else
    // orientFromHitPosition(player, te, face, hit);
    // }

    protected void orientOnPlacement(EntityPlayer player, ShapeTE te, BlockPos npos, IBlockState nstate, TileEntity nte,
            EnumFacing face, Vector3 hit) {
        if (te.shape.kind.orientOnPlacement(player, te, npos, nstate, nte, face, hit)) return;
        else orientFromHitPosition(player, te, face, hit);
    }

    public static boolean debugPlacement = false;

    protected void orientFromHitPosition(EntityPlayer player, ShapeTE te, EnumFacing face, Vector3 hit) {
        int side, turn;
        switch (face) {
            case UP:
                side = rightSideUpSide();
                break;
            case DOWN:
                if (te.shape.kind.canPlaceUpsideDown()) side = upsideDownSide();
                else side = rightSideUpSide();
                break;
            default:
                if (player.isSneaking()) side = oppositeFacing(face).ordinal();
                else if (hit.y > 0.0 && te.shape.kind.canPlaceUpsideDown()) side = upsideDownSide();
                else side = rightSideUpSide();
        }
        turn = turnForPlacementHit(side, hit, symmetry);
        if (debugPlacement && !getTileEntityWorld(te).isRemote) {
            System.out.printf("Shape.orientFromHitPosition: face %s global hit %s\n", face, hit);
            System.out.printf(
                    "Shape.orientFromHitPosition: side %s turn %s symmetry %s\n",
                    side,
                    turn,
                    te.shape.symmetry);
        }
        te.setSide(side);
        te.setTurn(turn);
        if ((flags & placeOffset) != 0) {
            te.setOffsetX(offsetXForPlacementHit(side, turn, hit));
            if (debugPlacement && !getTileEntityWorld(te).isRemote)
                System.out.printf("Shape.orientFromHitPosition: kind = %s offsetX = %.3f\n", kind, te.getOffsetX());
        }
    }

    public double offsetXForPlacementHit(int side, int turn, Vector3 hit) {
        Vector3 h = Trans3.sideTurn(side, turn).ip(hit);
        return signedPlacementOffsetX(h.x);
    }

    public double signedPlacementOffsetX(double sign) {
        double offx = kind.placementOffsetX();
        if (sign < 0) offx = -offx;
        return offx;
    }

    protected int rightSideUpSide() {
        if (isPlacedUnderneath()) return 1;
        else return 0;
    }

    protected int upsideDownSide() {
        if (isPlacedUnderneath()) return 0;
        else return 1;
    }

    protected boolean isPlacedUnderneath() {
        return (flags & placeUnderneath) != 0;
    }

    public static int turnForPlacementHit(int side, Vector3 hit, ShapeSymmetry symmetry) {
        Vector3 h = Trans3.sideTurn(side, 0).ip(hit);
        return turnForPlacementHit(symmetry, h.x, h.z);
    }

    private static int turnForPlacementHit(ShapeSymmetry symmetry, double x, double z) {
        switch (symmetry) {
            case Quadrilateral: // All rotations are equivalent
                return 0;
            case Bilateral: // Rotate according to nearest side
                if (abs(z) > abs(x)) return z < 0 ? 2 : 0;
                else return x > 0 ? 1 : 3;
            case Unilateral: // Rotate according to nearest corner
                if (z > 0) return x < 0 ? 0 : 1;
                else return x > 0 ? 2 : 3;
            default:
                return 0;
        }
    }

}
